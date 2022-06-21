package tech.antee.second.product_list.impl.domain.usecases

import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.ProductInList

interface GetProductListUsecase {

    suspend operator fun invoke(): Output<List<ProductInList>>
}
