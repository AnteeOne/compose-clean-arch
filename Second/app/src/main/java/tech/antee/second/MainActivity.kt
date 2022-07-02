package tech.antee.second

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import tech.antee.compose_network_manager.manager.NetworkManagerImpl
import tech.antee.compose_network_manager.ui.NetworkHandlingComponent
import tech.antee.compose_network_manager.ui.NetworkSnackComponent
import tech.antee.second.compose_features.LocalDestinations
import tech.antee.second.di.LocalAppProvider
import tech.antee.second.navigation.Navigation
import tech.antee.second.product_adding.impl.di.LocalProductAddingDependencies
import tech.antee.second.product_details.impl.di.LocalProductDetailsDependencies
import tech.antee.second.product_list.impl.di.LocalProductListDependencies
import tech.antee.second.theme.SecondTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondApp()
        }
    }

    @Composable
    private fun SecondApp() {
        SecondTheme {
            DependenciesProvider {
                NetworkHandlingSnackComponent {
                    Navigation()
                }
            }
        }
    }

    @Composable
    private fun DependenciesProvider(
        content: @Composable () -> Unit
    ) = CompositionLocalProvider(
        LocalAppProvider provides application.appProvider,
        LocalDestinations provides application.appProvider.destinations,
        LocalProductListDependencies provides application.appProvider,
        LocalProductDetailsDependencies provides application.appProvider,
        LocalProductAddingDependencies provides application.appProvider,
        content = content
    )

    @Composable
    fun NetworkHandlingSnackComponent(
        content: @Composable () -> Unit
    ) {
        val networkManager = remember { NetworkManagerImpl(application) }
        NetworkHandlingComponent(networkManager) {
            NetworkSnackComponent {
                content()
            }
        }
    }
}
