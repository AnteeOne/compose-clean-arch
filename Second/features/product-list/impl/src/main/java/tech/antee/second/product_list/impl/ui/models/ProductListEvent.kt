package tech.antee.second.product_list.impl.ui.models

sealed interface ProductListEvent {
    data class ShowError(val t: Throwable) : ProductListEvent
    data class NavigateToDetails(val guid: String) : ProductListEvent
    object NavigateToProductAdding : ProductListEvent
}
