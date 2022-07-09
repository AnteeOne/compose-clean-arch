package tech.antee.second.data.local.data_sources

import tech.antee.second.data.local.models.ProductEntity
import tech.antee.second.data.local.models.ProductInListEntity

interface ProductLocalDataSource {

    suspend fun getProductInList(): List<ProductInListEntity>

    suspend fun getProductDetails(guid: String): ProductEntity?

    suspend fun putProductsInList(products: List<ProductInListEntity>)

    suspend fun putProducts(products: List<ProductEntity>)

    suspend fun addProductDetails(productEntity: ProductEntity)

    suspend fun addProductInList(productInListEntity: ProductInListEntity)

    suspend fun putProductDetails(productEntity: ProductEntity): ProductEntity?

    suspend fun putProductInList(newEntity: ProductInListEntity)
}
