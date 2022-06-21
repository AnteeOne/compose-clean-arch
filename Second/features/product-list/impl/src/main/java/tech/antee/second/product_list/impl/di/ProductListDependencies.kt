package tech.antee.second.product_list.impl.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.second.domain.repositories.ProductRepository

interface ProductListDependencies {

    val productRepository: ProductRepository
}

val LocalProductListDependencies = compositionLocalOf<ProductListDependencies> {
    error("No feature deps provider found!")
}
