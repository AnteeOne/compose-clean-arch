package tech.antee.second.product_adding.impl.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.second.domain.repositories.ProductRepository

interface ProductAddingDependencies {

    val productRepository: ProductRepository
}

val LocalProductAddingDependencies = compositionLocalOf<ProductAddingDependencies> {
    error("No feature deps provider found!")
}
