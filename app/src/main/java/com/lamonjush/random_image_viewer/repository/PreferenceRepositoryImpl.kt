package com.lamonjush.random_image_viewer.repository

import com.lamonjush.random_image_viewer.datasource.PreferenceDataSource
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    dataSource: PreferenceDataSource
) : PreferenceRepository {
}