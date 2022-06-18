package tech.antee.second.product_adding.impl.domain.usecases

import tech.antee.second.domain.models.Product
import tech.antee.second.domain.repositories.ProductRepository

class AddProductUsecase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(product: Product) {
        return productRepository.addProduct(product)
    }
}
