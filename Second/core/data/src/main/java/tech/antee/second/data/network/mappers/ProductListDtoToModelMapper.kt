package tech.antee.second.data.network.mappers

import tech.antee.second.data.network.models.ProductInListDto
import tech.antee.second.domain.models.ProductInList

class ProductListDtoToModelMapper {

    fun map(from: ProductInListDto): ProductInList = with(from) {
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
