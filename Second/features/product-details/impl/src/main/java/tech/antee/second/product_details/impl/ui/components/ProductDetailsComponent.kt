package tech.antee.second.product_details.impl.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import tech.antee.second.product_details.impl.ui.custom_view_components.ShopCartBtnClickType
import tech.antee.second.product_details.impl.ui.custom_view_components.ShopCartButtonExtView
import tech.antee.second.product_details.impl.ui.models.ProductItem
import tech.antee.second.theme.Dimensions

@Composable
fun ProductDetailsComponent(
    productItem: ProductItem,
    onAddToCartClick: () -> Unit,
    onRemoveFromCartClick: () -> Unit,
    modifier: Modifier = Modifier
) = with(productItem) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            images.firstOrNull()?.let { imageUrl ->
                AsyncImage(
                    modifier = Modifier.height(ProductDetailsComponentDefaults.imageSize),
                    model = imageUrl, // TODO(fix): add view pager contains another images
                    contentDescription = null
                )
            }
            Spacer(Modifier.height(Dimensions.spacingVerticalXs))
            val productDetails =
                mutableListOf(name, description, "viewCount = $viewCount", "price = $price", "rating = $rating").apply {
                    if (isFavorite) add("In favs")
                    if (isInCart) add("InCart") // TODO: to string resourses OR LocalStringsModule with translation (Technocracy Habr Presentation)
                    weight?.let { add("weight = $it") }
                    count?.let { add("count = $it") }
                    additionalParams.forEach {
                        add("${it.key} = ${it.value}")
                    }
                }
            LazyColumn {
                itemsIndexed(productDetails) { index, text ->
                    Text(text)
                    if (index != productDetails.lastIndex) Spacer(Modifier.height(Dimensions.spacingVerticalXs))
                }
            }
        }
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = {
                ShopCartButtonExtView(it).apply {
                    setInCartCount(productItem.inCartItemCount)
                    setOnClickListener { type ->
                        when (type) {
                            ShopCartBtnClickType.OnAdd -> onAddToCartClick()
                            ShopCartBtnClickType.OnRemove -> onRemoveFromCartClick()
                        }
                    }
                }
            }
        )
    }
}

private object ProductDetailsComponentDefaults {
    val imageSize = 320.dp
}
