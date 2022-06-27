package tech.antee.second.data.workers.domain.usecases

import tech.antee.second.domain.models.EmptyOutput
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class FetchProductDetailsUsecaseImpl @Inject constructor(  // TODO: separate to another module
    private val productRepository: ProductRepository
) : FetchProductDetailsUsecase {

    override suspend fun invoke(): EmptyOutput {
        return productRepository.fetchProductDetails()
    }
}
