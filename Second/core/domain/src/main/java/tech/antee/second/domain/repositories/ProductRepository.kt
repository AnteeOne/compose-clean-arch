package tech.antee.second.domain.repositories

import kotlinx.coroutines.flow.Flow
import tech.antee.second.domain.models.EmptyOutput
import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.models.ProductInList

interface ProductRepository {

    val deviceListFlow: Flow<List<ProductInList>>

    suspend fun fetchProductList(): EmptyOutput

    suspend fun fetchProductDetails(): EmptyOutput

    suspend fun getProductDetails(guid: String): Output<Product>

    suspend fun addProduct(product: Product)
}
