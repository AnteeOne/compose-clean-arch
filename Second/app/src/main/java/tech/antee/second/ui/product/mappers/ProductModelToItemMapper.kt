package tech.antee.second.ui.product.mappers

import tech.antee.second.domain.models.Product
import tech.antee.second.ui.product.models.ProductItem

class ProductModelToItemMapper {

    fun map(from: Product) = with(from) {
        ProductItem(
            guid,
            name,
            price,
            description,
            rating,
            isFavorite,
            isInCart,
            images,
            weight,
            count,
            availableCount,
            additionalParams
        )
    }
}
