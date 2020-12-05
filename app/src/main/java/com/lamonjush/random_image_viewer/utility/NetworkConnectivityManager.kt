package com.lamonjush.random_image_viewer.utility

import android.net.ConnectivityManager

interface NetworkConnectivityManager {

    fun startNetworkCallback(callback: ConnectivityManager.NetworkCallback)

    fun stopNetworkCallback()
}