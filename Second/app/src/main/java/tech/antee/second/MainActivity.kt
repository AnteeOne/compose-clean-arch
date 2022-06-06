package tech.antee.second

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tech.antee.second.ui.mock_di.UiContainer
import tech.antee.second.ui.navigation.Destination
import tech.antee.second.ui.product_list.ProductListScreen
import tech.antee.second.ui.theme.SecondTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Destination.ProductListDestination.route) {
                    composable(route = Destination.Product.route) {
                    }
                    composable(
                        route = Destination.ProductListDestination.route,
                        arguments = listOf(navArgument("productId") { type = NavType.StringType })
                    ) {
                        val viewModel = UiContainer.productListViewModel
                        ProductListScreen(viewModel = viewModel, navController = navController)
                    }
                }
            }
        }
    }
}
