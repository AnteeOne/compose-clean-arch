package tech.antee.second.product_list.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tech.antee.second.product_list.impl.domain.usecases.GetProductListUsecase
import tech.antee.second.product_list.impl.ui.mappers.ProductListModelToItemMapper
import tech.antee.second.product_list.impl.ui.models.ProductListAction
import tech.antee.second.product_list.impl.ui.models.ProductListEvent
import tech.antee.second.product_list.impl.ui.models.ProductListUiState
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getProductListUsecase: GetProductListUsecase,
) : ViewModel() {

    private val mapper by lazy { ProductListModelToItemMapper() } // TODO : PROVIDE BY DI

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
            getProductListUsecase.invoke().collect {
                _uiState.value = ProductListUiState.Success(it.map(mapper::map))
            }
        }
    }

    private fun navigateToDetails(guid: String) {
        _events.trySend(ProductListEvent.NavigateToDetails(guid))
    }
}
