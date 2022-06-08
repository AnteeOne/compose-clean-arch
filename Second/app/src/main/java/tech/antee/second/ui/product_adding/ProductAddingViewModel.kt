package tech.antee.second.ui.product_adding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech.antee.second.domain.usecases.AddProductUsecase
import tech.antee.second.ui.product.mappers.ProductModelToItemMapper
import tech.antee.second.ui.product.models.ProductItem
import tech.antee.second.ui.product_adding.models.ProductAddingAction
import tech.antee.second.ui.product_adding.models.ProductAddingEvent

class ProductAddingViewModel(
    private val addProductUsecase: AddProductUsecase,
    private val productModelToItemMapper: ProductModelToItemMapper
) : ViewModel() {

    private var _events = Channel<ProductAddingEvent>(capacity = Channel.UNLIMITED)
    val events: Flow<ProductAddingEvent> = _events.receiveAsFlow()

    val productDetailsState = mutableStateOf(
        ProductItem(
            guid = "",
            name = "",
            price = "",
            description = "",
            rating = 0.0,
            isFavorite = false,
            isInCart = false,
            images = mutableListOf(""),
            viewCount = 0,
            additionalParams = mapOf(),
            availableCount = null,
            weight = null,
            count = null
        )
    )

    fun onAction(action: ProductAddingAction) {
        when (action) {
            ProductAddingAction.OnProductAddingButtonClick -> addProduct()
        }
    }

    private fun addProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            addProductUsecase(productModelToItemMapper.mapBack(productDetailsState.value))
            _events.trySend(ProductAddingEvent.NavigateBack)
        }
    }
}
