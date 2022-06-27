package tech.antee.second.data.local.mappers

import tech.antee.second.data.local.models.ProductEntity
import tech.antee.second.domain.models.Product

class ProductEntityToModelMapper {

    fun map(from: ProductEntity): Product = with(from) {
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
            additionalParams,
            viewCount
        )
    }

    fun mapBack(from: Product): ProductEntity = with(from) {
        ProductEntity(
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
}
