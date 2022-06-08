package tech.antee.second.data.repository

import kotlinx.coroutines.CancellationException
import tech.antee.second.data.data_sources.ProductRemoteDataSource
import tech.antee.second.data.mappers.ProductDtoToModelMapper
import tech.antee.second.data.mappers.ProductListDtoToModelMapper
import tech.antee.second.data.models.Result
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val remoteProductDataSource: ProductRemoteDataSource,
    private val productListDtoToModelMapper: ProductListDtoToModelMapper,
    private val productDtoToModelMapper: ProductDtoToModelMapper
) : ProductRepository {

    override suspend fun getProductList(): Result<List<ProductInList>> {
        return try {
            val dtoList = remoteProductDataSource.fetchProductList()
            return Result.Success(dtoList.map { productListDtoToModelMapper.map(it) })
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Result.Error(t)
            }
        }
    }

    override suspend fun getProductDetails(guid: String): Result<Product> {
        return try {
            val dto = remoteProductDataSource.fetchProductDetails(guid)
            val updatedDto = remoteProductDataSource.putProductDetails(dto.copy(viewCount = dto.viewCount + 1))
            Result.Success(productDtoToModelMapper.map(updatedDto))
        } catch (t: Throwable) {
            when (t) {
                is CancellationException -> throw t
                else -> Result.Error(t)
            }
        }
    }
}
