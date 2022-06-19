package tech.antee.second.product_adding.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import tech.antee.second.compose_features.Destinations
import tech.antee.second.di.factory.injectedViewModel
import tech.antee.second.product_adding.ProductAddingFeature
import tech.antee.second.product_adding.impl.di.DaggerProductAddingComponent
import tech.antee.second.product_adding.impl.di.LocalProductAddingDependencies
import tech.antee.second.product_adding.impl.ui.ProductAddingScreen
import javax.inject.Inject

class ProductAddingFeatureImpl @Inject constructor() : ProductAddingFeature() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val deps = LocalProductAddingDependencies.current
        val viewModel = injectedViewModel {
            DaggerProductAddingComponent.factory()
                .create(deps)
                .viewModel
        }
        ProductAddingScreen(
            viewModel = viewModel,
            onNavigateBack = { navController.popBackStack() }
        )
    }
}
