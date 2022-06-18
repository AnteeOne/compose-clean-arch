package tech.antee.second.product_details.impl.ui.models

sealed interface ProductUiState {
    object Empty : ProductUiState
    object Loading : ProductUiState
    data class Success(val data: ProductItem) : ProductUiState
}
