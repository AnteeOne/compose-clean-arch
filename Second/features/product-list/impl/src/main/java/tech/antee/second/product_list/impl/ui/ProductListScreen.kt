package tech.antee.second.product_list.impl.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                        items(state.data) {
                            ProductListItemComponent(
                                item = it,
                                onClick = { viewModel.onAction(ProductListAction.OnDeviceClick(it.guid)) }
                            )
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
    Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
}
