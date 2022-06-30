package tech.antee.second.product_list.impl.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import tech.antee.second.product_list.impl.ui.models.ProductListAction
import tech.antee.second.product_list.impl.ui.models.ProductListEvent
import tech.antee.second.product_list.impl.ui.models.ProductListUiState
import tech.antee.second.product_list.impl.ui.ui_components.ProductListItemComponent
import tech.antee.second.theme.Dimensions

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    modifier: Modifier = Modifier,
    onDetailsClick: (productGuid: String) -> Unit,
    onProductAddingButtonClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        viewModel.fetchProductList()
        viewModel.events.collect {
            when (it) {
                is ProductListEvent.ShowError -> onError(it.t, context)
                is ProductListEvent.NavigateToDetails -> onDetailsClick(it.guid)
                is ProductListEvent.NavigateToProductAdding -> onProductAddingButtonClick()
            }
        }
    }
    DisposableEffect(context, lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> viewModel.onAction(ProductListAction.OnStartPeriodicFetching)
                Lifecycle.Event.ON_STOP -> viewModel.onAction(ProductListAction.OnStopPeriodicFetching)
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimensions.paddingHorizontalM,
                vertical = Dimensions.paddingVerticalM
            )
    ) {
        when (val state = uiState) {
            is ProductListUiState.Empty -> {}
            is ProductListUiState.Loading -> CircularProgressIndicator(modifier.align(Alignment.Center))
            is ProductListUiState.Success -> {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                    LazyColumn(modifier = Modifier.weight(1f)) {
                        itemsIndexed(state.data) { index, it ->
                            ProductListItemComponent(
                                item = it,
                                onClick = { viewModel.onAction(ProductListAction.OnDeviceClick(it.guid)) }
                            )
                            if (index != state.data.lastIndex) {
                                Divider(Modifier.fillMaxWidth().padding(vertical = Dimensions.paddingVerticalXs))
                            }
                        }
                    }
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { viewModel.onAction(ProductListAction.OnAddProductButtonClick) }
                    ) {
                        Text(text = "Add product", color = Color.White) // TODO: to strings
                    }
                }
            }
        }
    }
}

private fun onError(t: Throwable, context: Context) {
    t.printStackTrace()
    Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
}
