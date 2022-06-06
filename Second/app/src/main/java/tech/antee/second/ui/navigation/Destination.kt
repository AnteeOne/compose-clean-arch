package tech.antee.second.ui.navigation

sealed class Destination(
    val route: String
) {
    object ProductListDestination : Destination(route = "product_list")
    object Product : Destination(route = "product/{productId}") {
        fun buildRoute(guid: String) = "product/$guid"
    }
}
