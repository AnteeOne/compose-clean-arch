package tech.antee.second.data.network.mappers

import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.domain.models.Product

class ProductDtoToModelMapper {

    private val DEFAULT_VIEW_COUNT = 0
    private val DEFAULT_IN_CART_COUNT = 0

    fun map(from: ProductDto): Product = with(from) {
        Product(
            guid,
            name,
            price,
            description,
            rating,
            isFavorite,
            isInCart,
            DEFAULT_IN_CART_COUNT,
            images,
            weight,
            count,
            availableCount,
            additionalParams,
            DEFAULT_VIEW_COUNT
        )
    }

    fun mapBack(from: Product): ProductDto = with(from) {
        ProductDto(
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
