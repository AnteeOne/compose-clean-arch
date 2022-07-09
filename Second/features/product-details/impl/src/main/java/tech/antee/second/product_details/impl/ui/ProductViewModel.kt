package tech.antee.second.product_details.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tech.antee.second.domain.models.Output
import tech.antee.second.product_details.impl.domain.AddProductToCartUsecase
import tech.antee.second.product_details.impl.domain.GetProductUsecase
import tech.antee.second.product_details.impl.domain.RemoveProductFromCartUsecase
import tech.antee.second.product_details.impl.ui.mappers.ProductModelToItemMapper
import tech.antee.second.product_details.impl.ui.models.ProductAction
import tech.antee.second.product_details.impl.ui.models.ProductEvent
import tech.antee.second.product_details.impl.ui.models.ProductUiState
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductUsecase: GetProductUsecase,
    private val addProductToCartUsecase: AddProductToCartUsecase,
    private val removeProductFromCartUsecase: RemoveProductFromCartUsecase
) : ViewModel() {

    private val mapper by lazy { ProductModelToItemMapper() } // TODO: PROVIDE BY DI

    private val _events = Channel<ProductEvent>(capacity = Channel.UNLIMITED)
    val events: Flow<ProductEvent> = _events.receiveAsFlow()

    private var _uiState: MutableStateFlow<ProductUiState> = MutableStateFlow(ProductUiState.Empty)
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    fun onAction(action: ProductAction) {
        when (action) {
            is ProductAction.OnFetchProduct -> fetchProduct(action.guid,true)
            is ProductAction.OnAddToCartClick -> addProductToCart()
            is ProductAction.OnRemoveFromCartClick -> removeProductFromCart()
        }
    }

    private fun fetchProduct(guid: String,increaseViewCount: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = ProductUiState.Loading
            when (val result = getProductUsecase(guid,increaseViewCount)) {
                is Output.Error -> _events.trySend(ProductEvent.ShowError(result.t))
                is Output.Success -> _uiState.value = ProductUiState.Success(mapper.map(result.data))
            }
        }
    }

    private fun addProductToCart() {
        if (uiState.value is ProductUiState.Success) {
            val guid = (uiState.value as ProductUiState.Success).data.guid
            viewModelScope.launch {
                addProductToCartUsecase(guid)
                fetchProduct(guid,false)
            }
        }
    }

    private fun removeProductFromCart() {
        if (uiState.value is ProductUiState.Success) {
            val guid = (uiState.value as ProductUiState.Success).data.guid
            viewModelScope.launch {
                removeProductFromCartUsecase(guid)
                fetchProduct(guid,false)
            }
        }
    }
}
