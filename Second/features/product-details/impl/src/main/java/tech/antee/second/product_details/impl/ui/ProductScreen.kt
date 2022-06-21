package tech.antee.second.product_details.impl.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import tech.antee.second.product_details.impl.ui.components.ProductDetailsComponent
import tech.antee.second.product_details.impl.ui.models.ProductEvent
import tech.antee.second.product_details.impl.ui.models.ProductUiState
import tech.antee.second.theme.Dimensions

@Composable
fun ProductScreen(
    viewModel: ProductViewModel,
    productGuid: String,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.fetchProduct(productGuid)
        viewModel.events.collect {
            when (it) {
                is ProductEvent.ShowError -> onError(it.t, context)
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
            is ProductUiState.Empty -> {}
            is ProductUiState.Loading -> CircularProgressIndicator(modifier.align(Alignment.Center))
            is ProductUiState.Success -> ProductDetailsComponent(state.data)
        }
    }
}

private fun onError(t: Throwable, context: Context) {
    Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
}
