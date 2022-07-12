package tech.antee.second.product_list.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tech.antee.second.data.workers.domain.usecases.FetchProductDetailsUsecase
import tech.antee.second.data.workers.domain.usecases.FetchProductInListUsecase
import tech.antee.second.domain.models.EmptySuccess
import tech.antee.second.product_list.impl.domain.usecases.AddProductToCartUsecase
import tech.antee.second.product_list.impl.domain.usecases.GetProductListUsecase
import tech.antee.second.product_list.impl.ui.mappers.ProductListModelToItemMapper
import tech.antee.second.product_list.impl.ui.models.ProductListAction
import tech.antee.second.product_list.impl.ui.models.ProductListEvent
import tech.antee.second.product_list.impl.ui.models.ProductListUiState
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes

class ProductListViewModel @Inject constructor(
    private val getProductListUsecase: GetProductListUsecase,
    private val fetchProductInListUsecase: FetchProductInListUsecase,
    private val fetchProductDetailsUsecase: FetchProductDetailsUsecase,
    private val addProductToCartUsecase: AddProductToCartUsecase
) : ViewModel() {

    private val mapper by lazy { ProductListModelToItemMapper() } // TODO : PROVIDE BY DI

    private var _events = Channel<ProductListEvent>(capacity = UNLIMITED)
    val events: Flow<ProductListEvent> = _events.receiveAsFlow()

    private var _uiState: MutableStateFlow<ProductListUiState> = MutableStateFlow(ProductListUiState.Empty)
    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()

    private var devicesFetchingJob: Job? = null
    private val devicesFetchingPeriod = 5.minutes

    fun onAction(action: ProductListAction) {
        when (action) {
            is ProductListAction.OnProductClick -> navigateToDetails(action.guid)
            is ProductListAction.OnProductShopCartClick -> addProductToShopCart(action.guid)
            is ProductListAction.OnAddProductButtonClick -> _events.trySend(ProductListEvent.NavigateToProductAdding)
            is ProductListAction.OnStartPeriodicFetching -> startDevicesPeriodicFetching()
            is ProductListAction.OnStopPeriodicFetching -> stopDevicesPeriodicFetching()
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

    private fun startDevicesPeriodicFetching() {
        if (devicesFetchingJob == null) {
            viewModelScope.launch(Dispatchers.IO) {
                while (true) {
                    delay(devicesFetchingPeriod)
                    if (fetchProductInListUsecase() is EmptySuccess) fetchProductDetailsUsecase()
                }
            }
        }
    }

    private fun stopDevicesPeriodicFetching() {
        devicesFetchingJob?.cancel()
        devicesFetchingJob = null
    }

    private fun addProductToShopCart(guid: String) {
        viewModelScope.launch { addProductToCartUsecase(guid) }
    }

    private fun navigateToDetails(guid: String) {
        _events.trySend(ProductListEvent.NavigateToDetails(guid))
    }
}
