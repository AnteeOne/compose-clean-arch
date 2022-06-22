package tech.antee.second.data.network.data_sources

import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.data.network.models.ProductInListDto

interface ProductRemoteDataSource {

    suspend fun fetchProductList(): List<ProductInListDto>

    suspend fun fetchProductDetailsList(): List<ProductDto>
}
