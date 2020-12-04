package com.lamonjush.random_image_viewer.configuration.di

import com.lamonjush.random_image_viewer.datasource.PreferenceDataSource
import com.lamonjush.random_image_viewer.datasource.PreferenceDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindPreferenceDataSource(dataSource: PreferenceDataSourceImpl) : PreferenceDataSource
}