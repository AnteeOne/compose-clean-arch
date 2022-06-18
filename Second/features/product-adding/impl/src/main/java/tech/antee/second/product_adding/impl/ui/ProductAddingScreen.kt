package tech.antee.second.product_adding.impl.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import tech.antee.second.product_adding.impl.ui.models.ProductAddingAction
import tech.antee.second.product_adding.impl.ui.models.ProductAddingEvent
import tech.antee.second.theme.Dimensions

@Composable
fun ProductAddingScreen(
    viewModel: ProductAddingViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        viewModel.events.collect {
            when (it) {
                ProductAddingEvent.NavigateBack -> navController.popBackStack()
            }
        }
    }

    Box(
        modifier = modifier.fillMaxSize().padding(
            horizontal = Dimensions.paddingHorizontalM,
            vertical = Dimensions.paddingVerticalM
        )
    ) {
        // TODO: clean + refactor
        // TODO: add validation
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = viewModel.productDetailsState.value.guid,
                    onValueChange = {
                        viewModel.productDetailsState.value = viewModel.productDetailsState.value.copy(guid = it)
                    },
                    label = { Text("guid") }
                )
                Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
                TextField(
                    value = viewModel.productDetailsState.value.name,
                    onValueChange = {
                        viewModel.productDetailsState.value = viewModel.productDetailsState.value.copy(name = it)
                    },
                    label = { Text("name") }
                )
                Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
                TextField(
                    value = viewModel.productDetailsState.value.price,
                    onValueChange = {
                        viewModel.productDetailsState.value = viewModel.productDetailsState.value.copy(price = it)
                    },
                    label = { Text("price") }
                )
                Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
                TextField(
                    value = viewModel.productDetailsState.value.description,
                    onValueChange = {
                        viewModel.productDetailsState.value = viewModel.productDetailsState.value.copy(description = it)
                    },
                    label = { Text("description") }
                )
                Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
                TextField(
                    value = viewModel.productDetailsState.value.images[0],
                    onValueChange = {
                        viewModel.productDetailsState.value =
                            viewModel.productDetailsState.value.copy(images = listOf(it))
                    },
                    label = { Text("imageUrl") }
                )
                Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.onAction(ProductAddingAction.OnProductAddingButtonClick) }
            ) {
                Text(text = "Add product", color = Color.White) // TODO: to strings
            }
        }
    }
}
