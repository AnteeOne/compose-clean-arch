package tech.antee.second.data.network.data_sources

import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.data.network.models.ProductInListDto
import tech.antee.second.data.network.retrofit.ProductService
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : ProductRemoteDataSource {

    override suspend fun fetchProductList(): List<ProductInListDto> {
        return productService.getProductList()
    }

    override suspend fun fetchProductDetailsList(): List<ProductDto> {
        return productService.getProductDetailsList()
    }

//    override suspend fun fetchProductDetails(guid: String): ProductDto {
//        return mockProductDetailsList.firstOrNull { it.guid == guid } ?: productNotFoundError(guid)
//    }
//
//    override suspend fun addProductDetails(productDto: ProductDto) {
//        mockProductDetailsList.add(productDto)
//    } // TODO: REMOVE
//
//    override suspend fun addProductInList(productInListDto: ProductInListDto) {
//        mockProductList.add(productInListDto)
//    } // TODO: REMOVE
//
//    override suspend fun putProductDetails(productDto: ProductDto): ProductDto {
//        mockProductDetailsList = mockProductDetailsList.map {
//            if (it.guid == productDto.guid) productDto else it
//        }.toMutableList()
//        return mockProductDetailsList.firstOrNull { it.guid == productDto.guid }
//            ?: productNotFoundError(productDto.guid)
//    } // TODO: REMOVE
}
