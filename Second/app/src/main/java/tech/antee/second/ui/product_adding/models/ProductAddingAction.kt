package tech.antee.second.ui.product_adding.models

sealed interface ProductAddingAction {
    object OnProductAddingButtonClick : ProductAddingAction
}
