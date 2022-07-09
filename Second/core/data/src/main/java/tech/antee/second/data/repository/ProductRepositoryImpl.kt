package tech.antee.second.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import tech.antee.second.data.local.data_sources.ProductLocalDataSource
import tech.antee.second.data.local.mappers.ProductDetailsToListEntityMapper
import tech.antee.second.data.local.mappers.ProductEntityToModelMapper
import tech.antee.second.data.local.mappers.ProductListEntityToModelMapper
import tech.antee.second.data.mappers.ProductDtoToEntityMapper
import tech.antee.second.data.mappers.ProductListDtoToEntityMapper
import tech.antee.second.data.network.data_sources.ProductRemoteDataSource
import tech.antee.second.domain.models.*
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class ProductRepositoryImpl @Inject constructor(
    private val remoteProductDataSource: ProductRemoteDataSource,
    private val localProductDataSource: ProductLocalDataSource,
    private val productListEntityToModelMapper: ProductListEntityToModelMapper,
    private val productEntityToModelMapper: ProductEntityToModelMapper,
    private val productDetailsToListEntityMapper: ProductDetailsToListEntityMapper,
    private val productListDtoToEntityMapper: ProductListDtoToEntityMapper,
    private val productDtoToEntityMapper: ProductDtoToEntityMapper
) : ProductRepository {

    private val _productInListFlow: MutableStateFlow<List<ProductInList>> = MutableStateFlow(emptyList())
    override val deviceListFlow: Flow<List<ProductInList>> = _productInListFlow

    override suspend fun fetchProductList(): EmptyOutput {
        return try {
            val dtoList = remoteProductDataSource.fetchProductList()
            val entityList = dtoList.map(productListDtoToEntityMapper::map)
            localProductDataSource.putProductsInList(entityList)
            fetchProductListLocal()
            EmptySuccess
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Output.Error(t)
            }
        }
    }

    override suspend fun fetchProductListLocal(): EmptyOutput {
        return try {
            _productInListFlow.emit(localProductDataSource.getProductInList().map(productListEntityToModelMapper::map))
            EmptySuccess
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Output.Error(t)
            }
        }
    }

    override suspend fun fetchProductDetails(): EmptyOutput {
        return try {
            val dtoList = remoteProductDataSource.fetchProductDetailsList()
            val entityList = dtoList.map(productDtoToEntityMapper::map)
            localProductDataSource.putProducts(entityList)
            fetchProductListLocal()
            EmptySuccess
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Output.Error(t)
            }
        }
    }

    override suspend fun getProductDetails(guid: String): Output<Product> {
        return try {
            val entity = localProductDataSource.getProductDetails(guid)
            val updatedEntity =
                localProductDataSource.putProductDetails(entity!!.copy(viewCount = entity.viewCount + 1))
            Output.Success(productEntityToModelMapper.map(updatedEntity!!)) // TODO: wrap with null check
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Output.Error(t)
            }
        }
    }

    override suspend fun putProductToCart(guid: String) {
        with(localProductDataSource) {
            getProductDetails(guid)?.let { productDetails ->
                putProductDetails(productDetails.copy(isInCart = true))?.let {
                    putProductInList(productDetailsToListEntityMapper.map(it))
                    fetchProductListLocal()
                }
            }
        }
    }

    override suspend fun addProduct(product: Product) {
        val productEntity = productEntityToModelMapper.mapBack(product)
        localProductDataSource.apply {
            addProductDetails(productEntity)
            addProductInList(productDetailsToListEntityMapper.map(productEntity))
            fetchProductListLocal()
        }
    }
}
