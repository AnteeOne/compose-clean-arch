package tech.antee.second.data.mappers

import tech.antee.second.data.models.ProductDto
import tech.antee.second.data.models.ProductInListDto

class ProductDetailsToListDtoMapper {

    fun map(from: ProductDto): ProductInListDto = with(from) {
        ProductInListDto(guid, images[0], name, price, rating, isFavorite, isInCart)
    }
}
