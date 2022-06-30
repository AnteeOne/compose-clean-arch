package tech.antee.second.product_list.impl.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.second.data.workers.domain.usecases.FetchProductDetailsUsecase
import tech.antee.second.data.workers.domain.usecases.FetchProductInListUsecase
import tech.antee.second.domain.repositories.ProductRepository

interface ProductListDependencies {

    val productRepository: ProductRepository

    val fetchProductInListUsecase: FetchProductInListUsecase

    val fetchProductDetailsUsecase: FetchProductDetailsUsecase
}

val LocalProductListDependencies = compositionLocalOf<ProductListDependencies> {
    error("No feature deps provider found!")
}
