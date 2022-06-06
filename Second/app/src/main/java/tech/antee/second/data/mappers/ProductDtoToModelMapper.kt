package tech.antee.second.data.mappers

import tech.antee.second.data.models.ProductDto
import tech.antee.second.domain.models.Product

class ProductDtoToModelMapper {

    fun map(from: ProductDto): Product = with(from) {
        Product(
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
