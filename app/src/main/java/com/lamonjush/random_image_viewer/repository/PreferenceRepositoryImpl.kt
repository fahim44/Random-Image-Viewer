package com.lamonjush.random_image_viewer.repository

import com.lamonjush.random_image_viewer.datasource.PreferenceDataSource
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    private val dataSource: PreferenceDataSource
) : PreferenceRepository {

    private val imageKey = "RANDOM_IMAGE_KEY"

    override fun getImageData() = dataSource.get(imageKey)

    override suspend fun saveImageData(data: String) = dataSource.put(imageKey, data)
}