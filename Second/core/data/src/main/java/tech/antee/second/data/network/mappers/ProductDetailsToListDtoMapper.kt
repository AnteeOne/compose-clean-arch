package tech.antee.second.data.network.mappers

import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.data.network.models.ProductInListDto

class ProductDetailsToListDtoMapper {

    fun map(from: ProductDto): ProductInListDto = with(from) {
        ProductInListDto(guid, images, name, price, rating, isFavorite, isInCart)
    }
}
