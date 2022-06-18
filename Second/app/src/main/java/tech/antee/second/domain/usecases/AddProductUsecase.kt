package tech.antee.second.domain.usecases

import tech.antee.second.domain.models.Product
import tech.antee.second.domain.repository.ProductRepository

class AddProductUsecase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(product: Product) {
        return productRepository.addProduct(product)
    }
}
