package tech.antee.second.product_adding.impl.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech.antee.second.product_adding.impl.domain.usecases.AddProductUsecase
import tech.antee.second.product_adding.impl.ui.mappers.ProductAddingModelToItemMapper
import tech.antee.second.product_adding.impl.ui.models.ProductAddingAction
import tech.antee.second.product_adding.impl.ui.models.ProductAddingEvent
import tech.antee.second.product_adding.impl.ui.models.ProductAddingItem
import javax.inject.Inject

class ProductAddingViewModel @Inject constructor(
    private val addProductUsecase: AddProductUsecase,
) : ViewModel() {

    private val productModelToItemMapper by lazy { ProductAddingModelToItemMapper() } // TODO: PROVIDE BY DI

    private var _events = Channel<ProductAddingEvent>(capacity = Channel.UNLIMITED)
    val events: Flow<ProductAddingEvent> = _events.receiveAsFlow()

    val productDetailsState = mutableStateOf(
        ProductAddingItem(
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
