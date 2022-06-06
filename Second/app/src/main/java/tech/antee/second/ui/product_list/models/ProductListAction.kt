package tech.antee.second.ui.product_list.models

sealed interface ProductListAction {
    data class OnDeviceClick(val guid: String) : ProductListAction
}
