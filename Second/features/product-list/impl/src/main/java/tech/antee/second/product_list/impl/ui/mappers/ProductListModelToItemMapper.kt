package tech.antee.second.product_list.impl.ui.mappers

import tech.antee.second.domain.models.ProductInList
import tech.antee.second.product_list.impl.ui.models.ProductListItem

class ProductListModelToItemMapper {

    fun map(from: ProductInList) = with(from) {
        ProductListItem(guid, image, name, price, rating, isFavorite, isInCart)
    }
}
