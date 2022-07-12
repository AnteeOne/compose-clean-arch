package tech.antee.second.data.network.retrofit

import retrofit2.http.GET
import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.data.network.models.ProductInListDto

interface ProductService {

    @GET("ee6876a1-8c02-45aa-bde4-b91817a8b210")
    suspend fun getProductList(): List<ProductInListDto>

    @GET("d1b4763b-a5ea-471f-83bf-796da466e3d8")
    suspend fun getProductDetailsList(): List<ProductDto>
}
