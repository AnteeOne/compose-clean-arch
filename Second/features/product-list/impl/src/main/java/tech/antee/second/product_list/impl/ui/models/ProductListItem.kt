package tech.antee.second.product_list.impl.ui.models

data class ProductListItem(
    val guid: String,
    val images: List<String>,
    val name: String,
    val price: String,
    val rating: Double,
    val isFavorite: Boolean,
    val isInCart: Boolean
) {
    /* TODO: remove after validation adding */
    fun parseProductPrice(): Int {
        return try {
            price.toInt()
        } catch (e: NumberFormatException) {
            -1
        }
    }
}
