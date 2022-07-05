package tech.antee.second.data.local.mappers

import tech.antee.second.data.local.models.ProductEntity
import tech.antee.second.data.local.models.ProductInListEntity

class ProductDetailsToListEntityMapper {

    fun map(from: ProductEntity): ProductInListEntity = with(from) {
        ProductInListEntity(guid, images, name, price, rating, isFavorite, isInCart)
    }
}
