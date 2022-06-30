package tech.antee.compose_network_manager.models

sealed interface NetworkState {
    object Connected : NetworkState
    object Disconnected : NetworkState
}
