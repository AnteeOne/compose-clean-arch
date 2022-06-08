package tech.antee.second.ui.product_list

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import tech.antee.second.ui.navigation.Destination
import tech.antee.second.ui.product_list.models.ProductListAction
import tech.antee.second.ui.product_list.models.ProductListEvent
import tech.antee.second.ui.product_list.models.ProductListUiState
import tech.antee.second.ui.product_list.ui_components.ProductListItemComponent
import tech.antee.second.ui.theme.Dimensions

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect {
            when (it) {
                is ProductListEvent.ShowError -> onError(it.t, context)
                is ProductListEvent.NavigateToDetails -> navController.navigate(Destination.Product.buildRoute(it.guid))
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
                LazyColumn {
                    items(state.data) {
                        ProductListItemComponent(
                            item = it,
                            onClick = { viewModel.onAction(ProductListAction.OnDeviceClick(it.guid)) }
                        )
                    }
                }
            }
        }
    }
}

private fun onError(t: Throwable, context: Context) {
    Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
}
