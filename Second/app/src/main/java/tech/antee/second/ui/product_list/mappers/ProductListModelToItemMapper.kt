package tech.antee.second.ui.product_list.mappers

import tech.antee.second.domain.models.ProductInList
import tech.antee.second.ui.product_list.models.ProductListItem

class ProductListModelToItemMapper {

    fun map(from: ProductInList) = with(from) {
        ProductListItem(guid, image, name, price, rating, isFavorite, isInCart)
    }
}
