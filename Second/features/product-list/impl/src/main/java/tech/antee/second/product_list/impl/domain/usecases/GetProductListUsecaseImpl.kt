package tech.antee.second.product_list.impl.domain.usecases

import kotlinx.coroutines.flow.Flow
import tech.antee.second.domain.models.ProductInList
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Inject

class GetProductListUsecaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductListUsecase {

    override suspend operator fun invoke(): Flow<List<ProductInList>> {
        return productRepository.deviceListFlow
    }
}
