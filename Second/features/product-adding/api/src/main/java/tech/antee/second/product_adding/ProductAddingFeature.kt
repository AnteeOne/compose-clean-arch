package tech.antee.second.product_adding

import tech.antee.second.compose_features.ComposableFeature

abstract class ProductAddingFeature : ComposableFeature {

    final override val featureRoute = "product_adding"

    fun destination() = featureRoute
}
