package tech.antee.compose_network_manager.manager.ktx

import android.net.NetworkCapabilities

internal fun NetworkCapabilities.hasActiveTransport(): Boolean = hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
