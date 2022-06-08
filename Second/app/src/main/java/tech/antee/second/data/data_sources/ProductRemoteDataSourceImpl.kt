package tech.antee.second.data.data_sources

import kotlinx.coroutines.delay
import tech.antee.second.data.extensions.productNotFoundError
import tech.antee.second.data.mock_data.mockProductDetailsList
import tech.antee.second.data.mock_data.mockProductList
import tech.antee.second.data.models.ProductDto
import tech.antee.second.data.models.ProductInListDto

class ProductRemoteDataSourceImpl : ProductRemoteDataSource {

    override suspend fun fetchProductList(): List<ProductInListDto> {
        delay(2000)
        return mockProductList
    }

    override suspend fun fetchProductDetails(guid: String): ProductDto {
        delay(2000)
        return mockProductDetailsList.firstOrNull { it.guid == guid } ?: productNotFoundError(guid)
    }

    override suspend fun putProductDetails(productDto: ProductDto): ProductDto {
        mockProductDetailsList = mockProductDetailsList.map {
            if (it.guid == productDto.guid) productDto else it
        }.toMutableList()
        return mockProductDetailsList.firstOrNull { it.guid == productDto.guid }
            ?: productNotFoundError(productDto.guid)
    }
}
