package tech.antee.second.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import tech.antee.second.compose_features.LocalDestinations
import tech.antee.second.compose_features.find
import tech.antee.second.product_adding.ProductAddingFeature
import tech.antee.second.product_details.ProductDetailsFeature
import tech.antee.second.product_list.ProductListFeature

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalDestinations.current

    val productListFeature = destinations.find<ProductListFeature>()
    val productDetailsFeature = destinations.find<ProductDetailsFeature>()
    val productAddingFeature = destinations.find<ProductAddingFeature>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.1f)
                    )
                )
            )
    ) {
        NavHost(navController = navController, startDestination = productListFeature.destination()) {
            with(productListFeature) { composable(navController, destinations) }
            with(productDetailsFeature) { composable(navController, destinations) }
            with(productAddingFeature) { composable(navController, destinations) }
        }
    }
}
