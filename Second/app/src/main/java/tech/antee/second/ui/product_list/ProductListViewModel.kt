package tech.antee.second.ui.product_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tech.antee.second.data.models.Result
import tech.antee.second.domain.usecases.GetProductListUsecase
import tech.antee.second.ui.product_list.mappers.ProductListModelToItemMapper
import tech.antee.second.ui.product_list.models.ProductListAction
import tech.antee.second.ui.product_list.models.ProductListEvent
import tech.antee.second.ui.product_list.models.ProductListUiState

class ProductListViewModel(
    private val getProductListUsecase: GetProductListUsecase,
    private val mapper: ProductListModelToItemMapper
) : ViewModel() {

    private var _events = Channel<ProductListEvent>(capacity = UNLIMITED)
    val events: Flow<ProductListEvent> = _events.receiveAsFlow()

    private var _uiState: MutableStateFlow<ProductListUiState> = MutableStateFlow(ProductListUiState.Empty)
    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()

    fun onAction(action: ProductListAction) {
        when (action) {
            is ProductListAction.OnDeviceClick -> navigateToDetails(action.guid)
            is ProductListAction.OnAddProductButtonClick -> _events.trySend(ProductListEvent.NavigateToProductAdding)
        }
    }

    fun fetchProductList() {
        viewModelScope.launch {
            _uiState.value = ProductListUiState.Loading
            when (val result = getProductListUsecase()) {
                is Result.Error -> _events.trySend(ProductListEvent.ShowError(result.t))
                is Result.Success -> _uiState.value = ProductListUiState.Success(result.data.map { mapper.map(it) })
            }
        }
    }

    private fun navigateToDetails(guid: String) {
        _events.trySend(ProductListEvent.NavigateToDetails(guid))
    }
}
