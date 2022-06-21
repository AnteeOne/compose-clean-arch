package tech.antee.second.data.data_sources

import tech.antee.second.data.models.ProductDto
import tech.antee.second.data.models.ProductInListDto

interface ProductRemoteDataSource {

    suspend fun fetchProductList(): List<ProductInListDto>

    suspend fun fetchProductDetails(guid: String): ProductDto

    suspend fun addProductDetails(productDto: ProductDto)

    suspend fun addProductInList(productInListDto: ProductInListDto)

    suspend fun putProductDetails(productDto: ProductDto): ProductDto
}
