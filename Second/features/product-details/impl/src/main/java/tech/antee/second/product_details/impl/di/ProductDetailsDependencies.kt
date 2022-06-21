package tech.antee.second.product_details.impl.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.second.domain.repositories.ProductRepository

interface ProductDetailsDependencies {

    val productRepository: ProductRepository
}

val LocalProductDetailsDependencies = compositionLocalOf<ProductDetailsDependencies> {
    error("No feature deps provider found!")
}
