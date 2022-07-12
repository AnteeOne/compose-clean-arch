package tech.antee.second.product_details.impl.ui.mappers

import tech.antee.second.domain.models.Product
import tech.antee.second.product_details.impl.ui.models.ProductItem

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
            inCartItemCount,
            images,
            weight,
            count,
            availableCount,
            additionalParams,
            viewCount
        )
    }

    fun mapBack(from: ProductItem) = with(from) {
        Product(
            guid,
            name,
            price,
            description,
            rating,
            isFavorite,
            isInCart,
            inCartItemCount,
            images,
            weight,
            count,
            availableCount,
            additionalParams,
            viewCount
        )
    }
}
