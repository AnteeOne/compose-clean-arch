package tech.antee.second.data.local.data_sources

import android.util.Log
import javax.inject.Inject

class ShopCartDataSourceImpl @Inject constructor() : ShopCartDataSource {

    private val shopCart by lazy(mode = LazyThreadSafetyMode.NONE) { HashMap<String, Int>() }

    override fun containsProduct(guid: String): Boolean = shopCart.contains(guid)

    override fun getProductCountInCart(guid: String): Int = when (guid) {
        in shopCart.keys -> requireNotNull(shopCart[guid])
        else -> 0
    }

    override fun addProduct(guid: String) {
        when (guid) {
            !in shopCart.keys -> shopCart[guid] = BORDER_PRODUCT_COUNT
            else -> shopCart[guid] = requireNotNull(shopCart[guid]) + 1
        }
        Log.d(TAG,"Added product with guid = $guid, current shop cart = $shopCart")
    }

    override fun deleteProduct(guid: String) {
        when {
            guid !in shopCart.keys -> error("Cart doesn't contains product with guid = $guid")
            shopCart[guid] == BORDER_PRODUCT_COUNT -> shopCart.remove(guid)
            else -> shopCart[guid] = requireNotNull(shopCart[guid]) - 1
        }
    }

    private companion object {
        const val BORDER_PRODUCT_COUNT = 1
        const val TAG = "ShopCartDataSourceImpl"
    }
}
