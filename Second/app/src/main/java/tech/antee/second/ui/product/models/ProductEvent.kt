package tech.antee.second.ui.product.models

sealed interface ProductEvent {
    data class ShowError(val t: Throwable) : ProductEvent
}
