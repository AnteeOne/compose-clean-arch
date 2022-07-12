package tech.antee.second.product_list.impl.ui.models

sealed interface ProductListAction {
    data class OnProductClick(val guid: String) : ProductListAction
    data class OnProductShopCartClick(val guid: String) : ProductListAction
    object OnAddProductButtonClick : ProductListAction
    object OnStartPeriodicFetching : ProductListAction
    object OnStopPeriodicFetching : ProductListAction
}
