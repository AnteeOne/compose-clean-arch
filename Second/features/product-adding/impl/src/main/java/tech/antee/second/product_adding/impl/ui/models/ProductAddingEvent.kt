package tech.antee.second.product_adding.impl.ui.models

sealed interface ProductAddingEvent {
    object NavigateBack : ProductAddingEvent
}
