package tech.antee.compose_network_manager.manager

import kotlinx.coroutines.flow.Flow
import tech.antee.compose_network_manager.models.NetworkState

interface NetworkManager {

    val networkStateFlow: Flow<NetworkState>

    fun onStart()

    fun onStop()

    fun checkNetworkConnection()
}
