package tech.antee.second.product_list.impl.ui.recycler.models

import tech.antee.second.product_list.impl.ui.models.ProductListItem

sealed interface RecyclerItem {
    data class Header(val title: String) : RecyclerItem
    data class Product(val productItem: ProductListItem) : RecyclerItem
}

internal fun RecyclerItem.getViewType(): Int = when (this) {
    is RecyclerItem.Header -> RecycleItemViewType.HEADER.viewType
    is RecyclerItem.Product -> RecycleItemViewType.PRODUCT.viewType
}

enum class RecycleItemViewType(val viewType: Int) {
    HEADER(0),
    PRODUCT(1)
}
