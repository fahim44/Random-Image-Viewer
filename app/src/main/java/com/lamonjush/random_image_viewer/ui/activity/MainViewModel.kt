package com.lamonjush.random_image_viewer.ui.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lamonjush.random_image_viewer.facility.ImageFacility
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    @ApplicationContext private val context: Context,
    facility: ImageFacility
) : ViewModel() {

    private val _netWorkAvailableMutableLiveData : MutableLiveData<Boolean> = MutableLiveData()
    val netWorkAvailableLiveData : LiveData<Boolean> get() = _netWorkAvailableMutableLiveData

    init {
        startNetworkCallback()
    }

    override fun onCleared() {
        stopNetworkCallback()
        super.onCleared()
    }

    private fun startNetworkCallback() {
        Timber.d("Start network callback")
        val networkRequestBuilder: NetworkRequest.Builder = NetworkRequest.Builder()
        getConnectivityManager()?.registerNetworkCallback(
            networkRequestBuilder.build(),
            object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    _netWorkAvailableMutableLiveData.postValue(true)
                    Timber.d("network available")
                }

                override fun onLost(network: Network) {
                    _netWorkAvailableMutableLiveData.postValue(false)
                    Timber.d("network lost")
                }
            })
    }

    private fun stopNetworkCallback() {
        Timber.d("stop network callback")
        getConnectivityManager()?.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
    }

    private fun getConnectivityManager() = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
}