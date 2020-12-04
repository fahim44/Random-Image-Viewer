package com.lamonjush.random_image_viewer.configuration.di

import com.lamonjush.random_image_viewer.facility.ImageFacility
import com.lamonjush.random_image_viewer.facility.ImageFacilityImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class FacilityModule {

    @Binds
    abstract fun bindImageFacility(facility: ImageFacilityImpl): ImageFacility
}