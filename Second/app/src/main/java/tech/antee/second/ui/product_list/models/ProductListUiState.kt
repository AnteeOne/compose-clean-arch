package tech.antee.second.ui.product_list.models

sealed interface ProductListUiState {
    object Empty : ProductListUiState
    object Loading : ProductListUiState
    data class Success(val data: List<ProductListItem>) : ProductListUiState
}
