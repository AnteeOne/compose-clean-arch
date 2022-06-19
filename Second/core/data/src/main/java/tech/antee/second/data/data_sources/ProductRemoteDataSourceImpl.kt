package tech.antee.second.data.data_sources

import tech.antee.second.data.extensions.productNotFoundError
import tech.antee.second.data.mock_data.mockProductDetailsList
import tech.antee.second.data.mock_data.mockProductList
import tech.antee.second.data.models.ProductDto
import tech.antee.second.data.models.ProductInListDto
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor() : ProductRemoteDataSource {

    override suspend fun fetchProductList(): List<ProductInListDto> {
        return mockProductList
    }

    override suspend fun fetchProductDetails(guid: String): ProductDto {
        return mockProductDetailsList.firstOrNull { it.guid == guid } ?: productNotFoundError(guid)
    }

    override suspend fun addProductDetails(productDto: ProductDto) {
        mockProductDetailsList.add(productDto)
    }

    override suspend fun addProductInList(productInListDto: ProductInListDto) {
        mockProductList.add(productInListDto)
    }

    override suspend fun putProductDetails(productDto: ProductDto): ProductDto {
        mockProductDetailsList = mockProductDetailsList.map {
            if (it.guid == productDto.guid) productDto else it
        }.toMutableList()
        return mockProductDetailsList.firstOrNull { it.guid == productDto.guid }
            ?: productNotFoundError(productDto.guid)
    }
}
