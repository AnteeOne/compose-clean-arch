package tech.antee.second.data.workers.domain.usecases

import tech.antee.second.domain.models.EmptyOutput
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class FetchProductInListUsecaseImpl @Inject constructor( // TODO: separate to another module
    private val productRepository: ProductRepository
) : FetchProductInListUsecase {

    override suspend fun invoke(): EmptyOutput {
        return with(productRepository) {
            fetchProductListLocal()
            fetchProductList()
        }
    }
}
