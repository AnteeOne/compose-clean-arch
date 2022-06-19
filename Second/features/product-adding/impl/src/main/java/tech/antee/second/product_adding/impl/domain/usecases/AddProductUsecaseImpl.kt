package tech.antee.second.product_adding.impl.domain.usecases

import tech.antee.second.domain.models.Product
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class AddProductUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : AddProductUsecase {

    override suspend operator fun invoke(product: Product) {
        return productRepository.addProduct(product)
    }
}
