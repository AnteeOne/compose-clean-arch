package tech.antee.second.product_list

import tech.antee.second.compose_features.ComposableFeature

abstract class ProductListFeature : ComposableFeature {

    final override val featureRoute = "product_list"

    fun destination() = featureRoute
}
