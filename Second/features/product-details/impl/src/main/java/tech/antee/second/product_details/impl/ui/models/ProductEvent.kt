package tech.antee.second.product_details.impl.ui.models

sealed interface ProductEvent {
    data class ShowError(val t: Throwable) : ProductEvent
}
