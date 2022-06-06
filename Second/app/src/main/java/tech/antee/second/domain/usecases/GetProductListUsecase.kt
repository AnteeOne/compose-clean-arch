package tech.antee.second.domain.usecases

import tech.antee.second.data.models.Result
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.repository.ProductRepository

class GetProductListUsecase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(): Result<List<ProductInList>> {
        return productRepository.getProductList()
    }
}
