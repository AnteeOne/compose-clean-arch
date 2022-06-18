package tech.antee.second

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tech.antee.second.product_adding.impl.ui.ProductAddingScreen
import tech.antee.second.product_details.impl.ui.ProductScreen
import tech.antee.second.product_list.impl.ui.ProductListScreen
import tech.antee.second.theme.SecondTheme
import tech.antee.second.ui.mock_di.UiContainer
import tech.antee.second.ui.navigation.Destination

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Destination.ProductList.route) {
                    composable(
                        route = Destination.Product.route,
                        arguments = listOf(
                            navArgument(Destination.Product.productIdArgument) {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val viewModel = UiContainer.productViewModel
                        it.arguments?.getString(Destination.Product.productIdArgument)?.let { guid ->
                            ProductScreen(
                                viewModel = viewModel,
                                productGuid = guid
                            )
                        }
                    }
                    composable(
                        route = Destination.ProductList.route,
                    ) {
                        val viewModel = UiContainer.productListViewModel
                        ProductListScreen(
                            viewModel = viewModel,
                            onDetailsClick = { navController.navigate(Destination.Product.buildRoute(it)) },
                            onProductAddingButtonClick = { navController.navigate(Destination.ProductAdding.route) }
                        )
                    }
                    composable(
                        route = Destination.ProductAdding.route
                    ) {
                        val viewModel = UiContainer.productAddingViewModel
                        ProductAddingScreen(viewModel = viewModel, navController = navController)
                    }
                }
            }
        }
    }
}
