package tech.antee.second.product_list.impl.domain.usecases

import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class AddProductToCartUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : AddProductToCartUsecase {

    override suspend fun invoke(productGuid: String) {
        with(productRepository) {
            putProductToCart(productGuid)
            fetchProductListLocal()
        }
    }
}
