package tech.antee.second.product_details.impl.domain

interface RemoveProductFromCartUsecase {

    suspend operator fun invoke(guid: String)
}
