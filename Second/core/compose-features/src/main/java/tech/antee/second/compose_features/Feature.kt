package tech.antee.second.compose_features

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable

/**
 * Base interface for new feature. Use [tech.antee.second.compose_features.ComposableFeature]
 * for implementation base simple case and [tech.antee.second.compose_features.GraphFeature] if feature has
 * nested navigation and contains its own navigation subgraph. Use this interfaces extension function
 * instead standard navigation library for implementing multi-module navigation
 *
 * @see [ComposableFeature]
 * @see [GraphFeature]
 **/
interface Feature {

    val featureRoute: String

    /**
     * Override this value if you need arguments for your feature
     *
     * @see [NamedNavArgument]
     */
    val arguments: List<NamedNavArgument>
        get() = emptyList()

    /**
     * Override this value if you need in links for your feature
     *
     * @see [NavDeepLink]
     */
    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}

/**
 * Use this interface for implementation base simple case.
 **/
interface ComposableFeature : Feature {

    fun NavGraphBuilder.composable(
        navController: NavHostController,
        destinations: Destinations
    ) {
        composable(featureRoute, arguments, deepLinks) { backStackEntry ->
            Composable(navController, destinations, backStackEntry)
        }
    }

    @Composable
    fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    )
}

/**
 * Use this interface if the feature has nested navigation and contains its own navigation subgraph
 **/
interface GraphFeature : Feature {

    fun NavGraphBuilder.navigation(navController: NavHostController, destinations: Destinations)
}
