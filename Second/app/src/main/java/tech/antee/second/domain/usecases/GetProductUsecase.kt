package tech.antee.second.domain.usecases

import tech.antee.second.data.models.Result
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.repository.ProductRepository

class GetProductUsecase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(guid: String): Result<Product> {
        return productRepository.getProductDetails(guid)
    }
}
