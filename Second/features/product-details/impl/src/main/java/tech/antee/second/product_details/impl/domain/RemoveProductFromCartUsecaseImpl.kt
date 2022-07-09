package tech.antee.second.product_details.impl.domain

import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class RemoveProductFromCartUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : RemoveProductFromCartUsecase {

    override suspend fun invoke(guid: String) {
        productRepository.removeProductFromCart(guid)
    }
}
