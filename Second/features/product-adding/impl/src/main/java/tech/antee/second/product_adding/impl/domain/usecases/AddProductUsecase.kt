package tech.antee.second.product_adding.impl.domain.usecases

import tech.antee.second.domain.models.Product

interface AddProductUsecase {

    suspend operator fun invoke(product: Product)
}
