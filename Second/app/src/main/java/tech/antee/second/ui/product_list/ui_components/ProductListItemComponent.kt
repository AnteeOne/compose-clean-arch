package tech.antee.second.ui.product_list.ui_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tech.antee.second.ui.product_list.models.ProductListItem
import tech.antee.second.ui.theme.Dimensions

@Composable
fun ProductListItemComponent(
    item: ProductListItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) = with(item) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Dimensions.paddingVerticalXs)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            AsyncImage(
                modifier = Modifier.height(64.dp),
                model = image,
                contentDescription = null
            )
            Spacer(Modifier.width(Dimensions.spacingHorizontalXs))
            Column {
                Text(text = name)
                if (isFavorite) {
                    Spacer(Modifier.height(Dimensions.spacingVerticalXs))
                    Text("Is favourite")
                }
                if (isInCart) {
                    Spacer(Modifier.height(Dimensions.spacingVerticalXs))
                    Text("In cart")
                }
            }
        }
        Column {
            Text(price)
            Spacer(Modifier.height(Dimensions.spacingVerticalXs))
            Text(rating.toString())
        }
    }
}

@Preview
@Composable
fun ProductListItemPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        ProductListItemComponent(
            item = ProductListItem(
                guid = "c3cfe1a8-6eec-4e9f-a260-490e128763f4",
                image = "https://cdn1.ozone.ru/s3/multimedia-4/6099200308.jpg",
                isFavorite = true,
                isInCart = false,
                name = "Молоко",
                price = "65",
                rating = 5.0
            ),
            onClick = {}
        )
    }
}
