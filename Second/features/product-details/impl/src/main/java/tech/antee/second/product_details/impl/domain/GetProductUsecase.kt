package tech.antee.second.product_details.impl.domain

import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.repositories.ProductRepository

class GetProductUsecase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(guid: String): Output<Product> {
        return productRepository.getProductDetails(guid)
    }
}
