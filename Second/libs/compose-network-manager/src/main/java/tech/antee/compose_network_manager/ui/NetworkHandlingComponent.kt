package tech.antee.compose_network_manager.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import kotlinx.coroutines.channels.Channel
import tech.antee.compose_network_manager.manager.NetworkManager
import tech.antee.compose_network_manager.models.LocalNetworkStateProvider
import tech.antee.compose_network_manager.models.NetworkStateProvider
import tech.antee.compose_network_manager.ui.effects.NetworkManagerLifecycleEffect
import tech.antee.compose_network_manager.ui.effects.NetworkStateCollectingEffect

@Composable
fun NetworkHandlingComponent(
    networkManager: NetworkManager,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalNetworkStateProvider provides NetworkStateProvider(Channel(capacity = Channel.UNLIMITED))
    ) {
        NetworkManagerLifecycleEffect(networkManager)
        NetworkStateCollectingEffect(networkManager)
        content()
    }
}
