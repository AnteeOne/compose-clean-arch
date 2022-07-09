package tech.antee.second.product_details.impl.domain

import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class AddProductToCartUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : AddProductToCartUsecase {

    override suspend fun invoke(guid: String): Int {
        return productRepository.putProductToCart(guid)
    }
}
