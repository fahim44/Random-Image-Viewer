package com.lamonjush.random_image_viewer.configuration.di

import com.lamonjush.random_image_viewer.repository.PreferenceRepository
import com.lamonjush.random_image_viewer.repository.PreferenceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPreferenceRepository(repository: PreferenceRepositoryImpl): PreferenceRepository
}