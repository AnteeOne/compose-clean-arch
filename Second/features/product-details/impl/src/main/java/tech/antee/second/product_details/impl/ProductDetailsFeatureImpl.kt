package tech.antee.second.product_details.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import tech.antee.second.compose_features.Destinations
import tech.antee.second.di.factory.injectedViewModel
import tech.antee.second.product_details.ProductDetailsFeature
import tech.antee.second.product_details.impl.di.DaggerProductDetailsComponent
import tech.antee.second.product_details.impl.di.LocalProductDetailsDependencies
import tech.antee.second.product_details.impl.ui.ProductScreen
import javax.inject.Inject

class ProductDetailsFeatureImpl @Inject constructor() : ProductDetailsFeature() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        backStackEntry.arguments?.getString(productIdArgument)?.let { productGuid ->
            val deps = LocalProductDetailsDependencies.current
            val viewModel = injectedViewModel {
                DaggerProductDetailsComponent.factory()
                    .create(deps)
                    .viewModel
            }
            ProductScreen(
                viewModel = viewModel,
                productGuid = productGuid
            )
        }
    }
}
