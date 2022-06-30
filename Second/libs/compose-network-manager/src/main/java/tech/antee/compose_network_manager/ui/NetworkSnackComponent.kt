package tech.antee.compose_network_manager.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.receiveAsFlow
import tech.antee.compose_network_manager.models.LocalNetworkStateProvider
import tech.antee.compose_network_manager.models.NetworkState

@Composable
fun NetworkSnackComponent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = with(DefaultNetworkComponentDefaults) {

    val networkStateProvider = LocalNetworkStateProvider.current
    var networkState by remember { mutableStateOf<NetworkState>(NetworkState.Connected) }

    LaunchedEffect(Unit) {
        networkStateProvider.networkState.receiveAsFlow().collect {
            networkState = it
        }
    }

    val networkSnackHeight = when (networkState) {
        NetworkState.Connected -> connectedSnackHeight
        NetworkState.Disconnected -> disconnectedSnackHeight
    }
    val networkSnackAnimatedHeight: Dp by animateDpAsState(
        targetValue = networkSnackHeight,
        animationSpec = heightAnimationEasing
    )

    val networkSnackColor = when (networkState) {
        NetworkState.Connected -> Green
        NetworkState.Disconnected -> Red
    }
    val networkSnackAnimatedColor by animateColorAsState(
        targetValue = networkSnackColor,
        animationSpec = colorAnimationEasing
    )

    val networkSnackText = when (networkState) {
        NetworkState.Connected -> "Connected" // TODO: to res
        NetworkState.Disconnected -> "Disconnected" // TODO: to res
    }

    Column(modifier.fillMaxSize()) {
        Column(modifier.weight(1f)) {
            content()
        }
        Box(
            modifier = Modifier
                .height(networkSnackAnimatedHeight)
                .fillMaxWidth()
                .background(networkSnackAnimatedColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = networkSnackText,
                style = MaterialTheme.typography.labelSmall,
                color = White
            )
        }
    }
}

private object DefaultNetworkComponentDefaults {
    val heightAnimationEasing = tween<Dp>(
        durationMillis = 500,
        delayMillis = 500,
        easing = LinearOutSlowInEasing
    )
    val colorAnimationEasing = tween<Color>(
        durationMillis = 500,
        easing = LinearOutSlowInEasing
    )
    val connectedSnackHeight = 0.dp
    val disconnectedSnackHeight = 24.dp
}
