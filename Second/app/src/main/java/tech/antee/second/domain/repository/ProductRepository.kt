package tech.antee.second.domain.repository

import tech.antee.second.data.models.Result
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.models.ProductInList

interface ProductRepository {

    suspend fun getProductList(): Result<List<ProductInList>>

    suspend fun getProductDetails(guid: String): Result<Product>
}
