package tech.antee.second.product_list.impl.ui.models

sealed interface ProductListUiState {
    object Empty : ProductListUiState
    object Loading : ProductListUiState
    data class Success(val data: List<ProductListItem>) : ProductListUiState
}
