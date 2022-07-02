package tech.antee.compose_network_manager.ui.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import tech.antee.compose_network_manager.manager.NetworkManager
import tech.antee.compose_network_manager.models.LocalNetworkStateProvider

@Composable
fun NetworkStateCollectingEffect(
    networkManager: NetworkManager
) {
    val localNetworkStateProvider = LocalNetworkStateProvider.current
    LaunchedEffect(Unit) {
        networkManager.networkStateFlow.collect { localNetworkStateProvider.networkState.trySend(it) }
    }
}
