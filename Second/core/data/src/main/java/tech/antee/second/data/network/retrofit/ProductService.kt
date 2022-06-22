package tech.antee.second.data.network.retrofit

import retrofit2.http.GET
import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.data.network.models.ProductInListDto

interface ProductService {

    @GET("50afcd4b-d81e-473e-827c-1b6cae1ea1b2")
    suspend fun getProductList(): List<ProductInListDto>

    @GET("8c374376-e94e-4c5f-aa30-a9eddb0d7d0a")
    suspend fun getProductDetailsList(): List<ProductDto>
}
