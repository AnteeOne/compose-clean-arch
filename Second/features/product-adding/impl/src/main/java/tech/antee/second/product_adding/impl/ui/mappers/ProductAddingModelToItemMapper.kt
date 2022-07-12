package tech.antee.second.product_adding.impl.ui.mappers

import tech.antee.second.domain.models.Product
import tech.antee.second.product_adding.impl.ui.models.ProductAddingItem

class ProductAddingModelToItemMapper {

    fun map(from: Product) = with(from) {
        ProductAddingItem(
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
            additionalParams,
            viewCount
        )
    }

    fun mapBack(from: ProductAddingItem) = with(from) {
        Product(
            guid,
            name,
            price,
            description,
            rating,
            isFavorite,
            isInCart,
            0,
            images,
            weight,
            count,
            availableCount,
            additionalParams,
            viewCount
        )
    }
}
