package tech.antee.second.data.mappers

import tech.antee.second.data.local.models.ProductInListEntity
import tech.antee.second.data.network.models.ProductInListDto

class ProductListDtoToEntityMapper {

    fun map(from: ProductInListDto): ProductInListEntity = with(from) {
        ProductInListEntity(guid, image, name, price, rating, isFavorite, isInCart)
    }
}
