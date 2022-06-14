package tech.antee.second.ui.product_adding.models

sealed interface ProductAddingEvent {
    object NavigateBack : ProductAddingEvent
}
