package tech.antee.second.product_list.impl.domain.usecases

sealed interface AddProductToCartUsecase {

    suspend operator fun invoke(productGuid: String)
}
