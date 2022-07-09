package tech.antee.second.product_details.impl.domain

interface AddProductToCartUsecase {

    suspend operator fun invoke(guid: String)
}
