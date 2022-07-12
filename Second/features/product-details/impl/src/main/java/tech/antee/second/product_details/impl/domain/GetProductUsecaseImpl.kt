package tech.antee.second.product_details.impl.domain

import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.Product
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class GetProductUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductUsecase {

    override suspend operator fun invoke(guid: String, increaseViewCount: Boolean): Output<Product> {
        return productRepository.getProductDetails(guid, increaseViewCount)
    }
}
