package tech.antee.second.product_list.impl.domain.usecases

import kotlinx.coroutines.flow.Flow
import tech.antee.second.domain.models.ProductInList

interface GetProductListUsecase {

    suspend operator fun invoke(): Flow<List<ProductInList>> // TODO: output
}
