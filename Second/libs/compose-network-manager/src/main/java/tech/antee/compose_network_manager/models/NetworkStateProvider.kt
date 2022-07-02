package tech.antee.compose_network_manager.models

import androidx.compose.runtime.compositionLocalOf
import kotlinx.coroutines.channels.Channel

data class NetworkStateProvider(
    val networkState: Channel<NetworkState>
)

val LocalNetworkStateProvider = compositionLocalOf<NetworkStateProvider> { error("No provider found!") }
