package tech.antee.second.product_list.impl.domain.usecases

import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.repositories.ProductRepository

class GetProductListUsecase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(): Output<List<ProductInList>> {
        return productRepository.getProductList()
    }
}
