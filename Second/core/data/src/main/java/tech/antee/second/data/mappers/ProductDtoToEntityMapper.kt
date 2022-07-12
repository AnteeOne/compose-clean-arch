package tech.antee.second.data.mappers

import tech.antee.second.data.local.models.ProductEntity
import tech.antee.second.data.network.models.ProductDto

class ProductDtoToEntityMapper {

    fun map(from: ProductDto): ProductEntity = with(from) {
        ProductEntity(
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
            0
        )
    }
}
