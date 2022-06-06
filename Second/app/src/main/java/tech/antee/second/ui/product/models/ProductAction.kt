package tech.antee.second.ui.product.models

sealed interface ProductAction {
    object OnIncreaseCounter : ProductAction
}
