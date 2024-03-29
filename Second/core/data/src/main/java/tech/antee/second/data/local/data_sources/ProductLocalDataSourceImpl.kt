package tech.antee.second.data.local.data_sources

import android.content.SharedPreferences
import tech.antee.second.data.local.models.ProductEntity
import tech.antee.second.data.local.models.ProductInListEntity
import tech.antee.second.data.local.shared_preferences.SharedPrefsConfig
import tech.antee.second.data.local.shared_preferences.getList
import tech.antee.second.data.local.shared_preferences.putList
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(
    private val sharedPrefs: SharedPreferences
) : ProductLocalDataSource {

    override suspend fun getProductInList(): List<ProductInListEntity> {
        return productInListEntities() ?: emptyList()
    }

    override suspend fun getProductDetails(guid: String): ProductEntity? {
        return try {
            productDetailsEntities()?.first { it.guid == guid }
        } catch (t: Throwable) {
            null
        }
    }

    override suspend fun putProductsInList(products: List<ProductInListEntity>) {
        val oldListDiff = (productInListEntities() ?: emptyList())
            .filter { old -> !products.any { it.guid == old.guid } }
        sharedPrefs.putList(SharedPrefsConfig.LIST_PRODUCTS_KEY, products + oldListDiff)
    }

    override suspend fun putProducts(products: List<ProductEntity>) {
        val oldListDiff = (productDetailsEntities() ?: emptyList())
            .filter { old -> !products.any { it.guid == old.guid } }
        sharedPrefs.putList(SharedPrefsConfig.DETAILS_PRODUCTS_KEY, products + oldListDiff)
    }

    override suspend fun addProductDetails(productEntity: ProductEntity) {
        val newList = productDetailsEntities()?.toMutableList()?.apply {
            add(productEntity)
        }
        sharedPrefs.putList(SharedPrefsConfig.DETAILS_PRODUCTS_KEY, newList)
    }

    override suspend fun addProductInList(productInListEntity: ProductInListEntity) {
        val newList = productInListEntities()?.toMutableList()?.apply {
            add(productInListEntity)
        }
        sharedPrefs.putList(SharedPrefsConfig.LIST_PRODUCTS_KEY, newList)
    }

    override suspend fun putProductDetails(newEntity: ProductEntity): ProductEntity? {
        val newList = productDetailsEntities()?.map { oldEntity ->
            if (oldEntity.guid == newEntity.guid) newEntity else oldEntity
        }
        sharedPrefs.putList(SharedPrefsConfig.DETAILS_PRODUCTS_KEY, newList)
        return getProductDetails(newEntity.guid)
    }

    override suspend fun putProductInList(newEntity: ProductInListEntity) {
        val newList = productInListEntities()?.map { oldEntity ->
            if (oldEntity.guid == newEntity.guid) newEntity else oldEntity
        }
        sharedPrefs.putList(SharedPrefsConfig.LIST_PRODUCTS_KEY, newList)
    }

    private fun productInListEntities(): List<ProductInListEntity>? =
        sharedPrefs.getList(SharedPrefsConfig.LIST_PRODUCTS_KEY)

    private fun productDetailsEntities(): List<ProductEntity>? =
        sharedPrefs.getList(SharedPrefsConfig.DETAILS_PRODUCTS_KEY)
}
