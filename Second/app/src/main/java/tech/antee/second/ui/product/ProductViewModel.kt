package tech.antee.second.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tech.antee.second.data.models.Result
import tech.antee.second.domain.usecases.GetProductUsecase
import tech.antee.second.ui.product.mappers.ProductModelToItemMapper
import tech.antee.second.ui.product.models.ProductAction
import tech.antee.second.ui.product.models.ProductEvent
import tech.antee.second.ui.product.models.ProductUiState

class ProductViewModel(
    private val getProductUsecase: GetProductUsecase,
    private val mapper: ProductModelToItemMapper
) : ViewModel() {

    private val _events = Channel<ProductEvent>(capacity = Channel.UNLIMITED)
    private val events: Flow<ProductEvent> = _events.receiveAsFlow()

    private var _uiState: MutableStateFlow<ProductUiState> = MutableStateFlow(ProductUiState.Empty)
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    fun onAction(action: ProductAction) {
        when (action) {
            is ProductAction.OnIncreaseCounter -> increaseCounter()
        }
    }

    private fun fetchProduct(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getProductUsecase(guid)) {
                is Result.Error -> _events.trySend(ProductEvent.ShowError(result.t))
                is Result.Success -> _uiState.value = ProductUiState.Success(mapper.map(result.data))
            }
        }
    }

    private fun increaseCounter() {
        // TODO()
    }
}
