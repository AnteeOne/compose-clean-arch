package tech.antee.second.product_list.impl.domain.usecases

import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class GetProductListUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductListUsecase {

    override suspend operator fun invoke(): Output<List<ProductInList>> {
        return productRepository.getProductList()
    }
}
