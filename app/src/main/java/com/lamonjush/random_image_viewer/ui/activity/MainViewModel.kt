package com.lamonjush.random_image_viewer.ui.activity

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.Network
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.lamonjush.random_image_viewer.facility.ImageFacility
import com.lamonjush.random_image_viewer.utility.NetworkConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    @ApplicationContext private val applicationContext: Context,
    private val facility: ImageFacility,
    private val networkConnectivityManager: NetworkConnectivityManager
) : ViewModel() {

    private val _netWorkAvailableMutableLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val netWorkAvailableLiveData: LiveData<Boolean> get() = _netWorkAvailableMutableLiveData

    val bitmapLiveData: LiveData<Bitmap> = liveData {
        facility.getImage()
            .catch { Timber.e(it) }
            .collect { emit(it) }
    }

    init {
        startNetworkCallback()
    }

    override fun onCleared() {
        networkConnectivityManager.stopNetworkCallback()
        super.onCleared()
    }

    private fun startNetworkCallback() {
        networkConnectivityManager.startNetworkCallback(
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

    fun canFetchImage() = _netWorkAvailableMutableLiveData.value ?: false

    fun imageFetched(bitmap: Bitmap) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                facility.putImage(bitmap)
            }
        }
    }
}