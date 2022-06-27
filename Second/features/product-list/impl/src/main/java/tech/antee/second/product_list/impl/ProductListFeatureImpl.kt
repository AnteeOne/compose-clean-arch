package tech.antee.second.product_list.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import tech.antee.second.compose_features.Destinations
import tech.antee.second.compose_features.find
import tech.antee.second.data.workers.ProductFetchStarter
import tech.antee.second.di.factory.injectedViewModel
import tech.antee.second.product_adding.ProductAddingFeature
import tech.antee.second.product_details.ProductDetailsFeature
import tech.antee.second.product_list.ProductListFeature
import tech.antee.second.product_list.impl.di.DaggerProductListComponent
import tech.antee.second.product_list.impl.di.LocalProductListDependencies
import tech.antee.second.product_list.impl.ui.ProductListScreen
import javax.inject.Inject

class ProductListFeatureImpl @Inject constructor(
    private val productFetchStarter: ProductFetchStarter
) : ProductListFeature() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val productDetailsFeature = destinations.find<ProductDetailsFeature>()
        val productAddingFeature = destinations.find<ProductAddingFeature>()

        val deps = LocalProductListDependencies.current
        val viewModel = injectedViewModel {
            DaggerProductListComponent.factory()
                .create(deps)
                .viewModel
        }
        ProductListScreen(
            viewModel = viewModel,
            onDetailsClick = { productGuid -> navController.navigate(productDetailsFeature.destination(productGuid)) },
            onProductAddingButtonClick = { navController.navigate(productAddingFeature.destination()) }
        )
        DisposableEffect(Unit) {
            productFetchStarter.start()
            onDispose {
                productFetchStarter.stop()
            }
        }
    }
}
