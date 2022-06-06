package tech.antee.second.ui.product_list.models

sealed interface ProductListEvent {
    data class ShowError(val t: Throwable) : ProductListEvent
    data class NavigateToDetails(val guid: String) : ProductListEvent
}
