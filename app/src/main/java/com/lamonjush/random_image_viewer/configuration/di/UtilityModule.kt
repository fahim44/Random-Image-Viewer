package com.lamonjush.random_image_viewer.configuration.di

import com.lamonjush.random_image_viewer.utility.BitmapMapper
import com.lamonjush.random_image_viewer.utility.BitmapMapperImpl
import com.lamonjush.random_image_viewer.utility.NetworkConnectivityManager
import com.lamonjush.random_image_viewer.utility.NetworkConnectivityManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class UtilityModule {

    @Binds
    abstract fun bindNetworkConnectivityManager(manager: NetworkConnectivityManagerImpl): NetworkConnectivityManager

    @Binds
    abstract fun bindBitmapMapper(mapperImpl: BitmapMapperImpl): BitmapMapper
}