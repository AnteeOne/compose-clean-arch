package tech.antee.second.domain.repositories

import tech.antee.second.domain.models.Product
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.models.Output

interface ProductRepository {

    suspend fun getProductList(): Output<List<ProductInList>>

    suspend fun getProductDetails(guid: String): Output<Product>

    suspend fun addProduct(product: Product)
}
