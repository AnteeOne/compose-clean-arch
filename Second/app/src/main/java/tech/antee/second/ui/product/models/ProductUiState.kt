package tech.antee.second.ui.product.models

sealed interface ProductUiState {
    object Empty : ProductUiState
    object Loading : ProductUiState
    data class Success(val data: ProductItem) : ProductUiState
}
