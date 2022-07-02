package tech.antee.compose_network_manager.manager

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.N
import android.util.Log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import tech.antee.compose_network_manager.manager.ktx.hasActiveTransport
import tech.antee.compose_network_manager.models.NetworkState

class NetworkManagerImpl(context: Context) : NetworkManager {

    private val TAG = "NetworkManagerImpl"

    private val _networkStateChannel = Channel<NetworkState>(capacity = Channel.UNLIMITED)
    override val networkStateFlow: Flow<NetworkState> = _networkStateChannel.receiveAsFlow()

    override fun onStart() {
        Log.d(TAG, "Registered network connection callback")
        when {
            SDK_INT >= N -> connectivityManager.registerDefaultNetworkCallback(connectivityManagerCallback)
            else -> lolipopNetworkRequest()
        }
    }

    override fun onStop() {
        Log.d(TAG, "Unregistered network connection callback")
        connectivityManager.unregisterNetworkCallback(connectivityManagerCallback)
    }

    override fun checkNetworkConnection() {
        Log.d(TAG, "Checking network connection...")
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities == null) {
            _networkStateChannel.trySend(NetworkState.Disconnected)
        } else {
            capabilities.apply {
                when {
                    hasActiveTransport() -> _networkStateChannel.trySend(NetworkState.Connected)
                    else -> _networkStateChannel.trySend(NetworkState.Disconnected)
                }
            }
        }
    }

    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private fun lolipopNetworkRequest() {
        val requestBuilder = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
        connectivityManager.registerNetworkCallback(
            requestBuilder.build(),
            connectivityManagerCallback
        )
    }

    private val connectivityManagerCallback: ConnectivityManager.NetworkCallback =
        object : ConnectivityManager.NetworkCallback() {

            override fun onLost(network: Network) {
                super.onLost(network)
                Log.d(TAG, "Network connection is lost")
                _networkStateChannel.trySend(NetworkState.Disconnected)
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                Log.d(TAG, "Network connection is available")
                _networkStateChannel.trySend(NetworkState.Connected)
            }
        }
}
