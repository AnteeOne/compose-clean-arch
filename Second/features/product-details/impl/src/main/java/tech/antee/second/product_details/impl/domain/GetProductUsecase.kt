package tech.antee.second.product_details.impl.domain

import tech.antee.second.domain.models.Output
import tech.antee.second.domain.models.Product

interface GetProductUsecase {
    suspend operator fun invoke(guid: String, increaseViewCount: Boolean): Output<Product>
}
