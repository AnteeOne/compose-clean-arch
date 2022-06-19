package tech.antee.second.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.second.compose_features.Destinations
import tech.antee.second.product_adding.impl.di.ProductAddingDependencies
import tech.antee.second.product_details.impl.di.ProductDetailsDependencies
import tech.antee.second.product_list.impl.di.ProductListDependencies

interface AppProvider :
    ProductListDependencies,
    ProductDetailsDependencies,
    ProductAddingDependencies {

    val destinations: Destinations

//    val dependencies: DependenciesMap // TODO: uncomment for providing deps to WorkManager
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
