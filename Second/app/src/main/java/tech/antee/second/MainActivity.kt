package tech.antee.second

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import tech.antee.second.di.LocalAppProvider
import tech.antee.second.product_adding.impl.di.LocalProductAddingDependencies
import tech.antee.second.product_details.impl.di.LocalProductDetailsDependencies
import tech.antee.second.product_list.impl.di.LocalProductListDependencies
import tech.antee.second.theme.SecondTheme
import tech.antee.second.ui.navigation.AppNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondTheme {
                DependenciesProvider {
                    AppNavigation()
                }
            }
        }
    }

    @Composable
    private fun DependenciesProvider(
        content: @Composable () -> Unit
    ) = CompositionLocalProvider(
        LocalAppProvider provides application.appProvider,
        LocalProductListDependencies provides application.appProvider,
        LocalProductDetailsDependencies provides application.appProvider,
        LocalProductAddingDependencies provides application.appProvider,
        content = content
    )
}
