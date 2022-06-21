package tech.antee.second.product_details

import androidx.navigation.NavType
import androidx.navigation.navArgument
import tech.antee.second.compose_features.ComposableFeature

abstract class ProductDetailsFeature : ComposableFeature {

    final override val featureRoute = "productDetails?productId={productId}"

    protected val productIdArgument = "productId"

    final override val arguments = listOf(
        navArgument("productId") {
            type = NavType.StringType
        }
    )

    private fun buildRoute(guid: String) = "productDetails?productId=$guid"

    fun destination(guid: String) = buildRoute(guid)
}
