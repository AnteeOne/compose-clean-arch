package tech.antee.second.product_details.impl.ui.models

sealed interface ProductAction {
    data class OnFetchProduct(val guid: String) : ProductAction
    object OnAddToCartClick : ProductAction
    object OnRemoveFromCartClick : ProductAction
}
