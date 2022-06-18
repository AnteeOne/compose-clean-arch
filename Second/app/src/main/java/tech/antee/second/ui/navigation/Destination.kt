package tech.antee.second.ui.navigation

sealed class Destination(
    val route: String
) {
    object ProductList : Destination(route = "product_list")
    object Product : Destination(route = "product/{productId}") {
        val productIdArgument = "productId"
        fun buildRoute(guid: String) = "product/$guid"
    }
    object ProductAdding : Destination(route = "product_adding")
}
