package tech.antee.second.data.local.data_sources

interface ShopCartDataSource {

    fun containsProduct(guid: String): Boolean

    fun getProductCountInCart(guid: String): Int

    fun addProduct(guid: String)

    fun deleteProduct(guid: String)
}
