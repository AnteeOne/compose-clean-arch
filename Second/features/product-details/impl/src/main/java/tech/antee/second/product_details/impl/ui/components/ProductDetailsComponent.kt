package tech.antee.second.product_details.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
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
    Box(modifier = modifier.fillMaxSize()) {
        var imageHeight by remember {
            mutableStateOf(0.dp)
        }
        val localDensity = LocalDensity.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .align(Alignment.TopCenter)
                .onGloballyPositioned {
                    imageHeight = with(localDensity) { it.size.height.toDp() }
                }
        ) {
            images.firstOrNull()?.let { imageUrl ->
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = imageUrl, // TODO(fix): add view pager contains another images
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f)),
                            startY = 500f
                        )
                    )
            )
        }
        Card(
            modifier = Modifier
                .height(imageHeight + 24.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            elevation = 4.dp,
            shape = RoundedCornerShape(topStart = Dimensions.cornersM, topEnd = Dimensions.cornersM),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = Dimensions.paddingHorizontalM,
                        end = Dimensions.paddingHorizontalM,
                        bottom = Dimensions.paddingVerticalXxl
                    )
                    .absoluteOffset(y = ProductDetailsComponentDefaults.cardOffset)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Spacer(Modifier.height(Dimensions.spacingVerticalXs))
                    Text(
                        text = name,
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(Modifier.height(Dimensions.spacingVerticalXs))
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "$price₽",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    AndroidView(
                        modifier = Modifier.fillMaxWidth(),
                        factory = { ShopCartButtonExtView(it) },
                        update = {
                            it.setInCartCount(productItem.inCartItemCount)
                            it.setOnClickListener { type ->
                                when (type) {
                                    ShopCartBtnClickType.OnAdd -> onAddToCartClick()
                                    ShopCartBtnClickType.OnRemove -> onRemoveFromCartClick()
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

private object ProductDetailsComponentDefaults {
    val imageSize = 320.dp
    val cardOffset = 24.dp
}
