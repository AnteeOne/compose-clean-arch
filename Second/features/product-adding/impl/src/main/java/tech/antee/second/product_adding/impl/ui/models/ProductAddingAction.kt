package tech.antee.second.product_adding.impl.ui.models

sealed interface ProductAddingAction {
    object OnProductAddingButtonClick : ProductAddingAction
}
