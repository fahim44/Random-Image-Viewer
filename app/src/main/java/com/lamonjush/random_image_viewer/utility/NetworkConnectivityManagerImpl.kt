package com.lamonjush.random_image_viewer.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject

class NetworkConnectivityManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
): NetworkConnectivityManager {

    override fun startNetworkCallback(callback: ConnectivityManager.NetworkCallback) {
        Timber.d("Start network callback")
        val networkRequestBuilder: NetworkRequest.Builder = NetworkRequest.Builder()
        getConnectivityManager()?.registerNetworkCallback(
            networkRequestBuilder.build(), callback
        )
    }

    override fun stopNetworkCallback() {
        Timber.d("stop network callback")
        getConnectivityManager()?.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
    }

    private fun getConnectivityManager() =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
}