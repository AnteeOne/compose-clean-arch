package tech.antee.second.product_list.impl.ui.models

data class ProductListItem(
    val guid: String,
    val image: String,
    val name: String,
    val price: String,
    val rating: Double,
    val isFavorite: Boolean,
    val isInCart: Boolean
)
