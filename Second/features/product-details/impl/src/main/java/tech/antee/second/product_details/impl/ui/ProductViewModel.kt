package tech.antee.second.product_details.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tech.antee.second.domain.models.Output
import tech.antee.second.product_details.impl.domain.GetProductUsecase
import tech.antee.second.product_details.impl.ui.mappers.ProductModelToItemMapper
import tech.antee.second.product_details.impl.ui.models.ProductEvent
import tech.antee.second.product_details.impl.ui.models.ProductUiState
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductUsecase: GetProductUsecase
) : ViewModel() {

    private val mapper by lazy { ProductModelToItemMapper() } // TODO: PROVIDE BY DI

    private val _events = Channel<ProductEvent>(capacity = Channel.UNLIMITED)
    val events: Flow<ProductEvent> = _events.receiveAsFlow()

    private var _uiState: MutableStateFlow<ProductUiState> = MutableStateFlow(ProductUiState.Empty)
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    fun fetchProduct(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = ProductUiState.Loading
            when (val result = getProductUsecase(guid)) {
                is Output.Error -> _events.trySend(ProductEvent.ShowError(result.t))
                is Output.Success -> _uiState.value = ProductUiState.Success(mapper.map(result.data))
            }
        }
    }
}
