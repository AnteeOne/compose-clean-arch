package tech.antee.second.data.local.mappers

import tech.antee.second.data.local.models.ProductInListEntity
import tech.antee.second.domain.models.ProductInList

class ProductListEntityToModelMapper {

    fun map(from: ProductInListEntity): ProductInList = with(from) {
        ProductInList(
            guid,
            image,
            name,
            price,
            rating,
            isFavorite,
            isInCart
        )
    }
}
