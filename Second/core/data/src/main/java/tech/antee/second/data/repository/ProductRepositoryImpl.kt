package tech.antee.second.data.repository

import tech.antee.second.data.data_sources.ProductRemoteDataSource
import tech.antee.second.data.mappers.ProductDetailsToListDtoMapper
import tech.antee.second.data.mappers.ProductDtoToModelMapper
import tech.antee.second.data.mappers.ProductListDtoToModelMapper
import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.repositories.ProductRepository
import kotlin.coroutines.cancellation.CancellationException

class ProductRepositoryImpl(
    private val remoteProductDataSource: ProductRemoteDataSource,
    private val productListDtoToModelMapper: ProductListDtoToModelMapper,
    private val productDtoToModelMapper: ProductDtoToModelMapper,
    private val productDetailsToListDtoMapper: ProductDetailsToListDtoMapper
) : ProductRepository {

    override suspend fun getProductList(): Output<List<ProductInList>> {
        return try {
            val dtoList = remoteProductDataSource.fetchProductList()
            return Output.Success(dtoList.map { productListDtoToModelMapper.map(it) })
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Output.Error(t)
            }
        }
    }

    override suspend fun getProductDetails(guid: String): Output<Product> {
        return try {
            val dto = remoteProductDataSource.fetchProductDetails(guid)
            val updatedDto = remoteProductDataSource.putProductDetails(dto.copy(viewCount = dto.viewCount + 1))
            Output.Success(productDtoToModelMapper.map(updatedDto))
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Output.Error(t)
            }
        }
    }

    override suspend fun addProduct(product: Product) {
        val productDto = productDtoToModelMapper.mapBack(product)
        remoteProductDataSource.addProductDetails(productDto)
        remoteProductDataSource.addProductInList(productDetailsToListDtoMapper.map(productDto))
    }
}
