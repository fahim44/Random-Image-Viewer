package com.lamonjush.random_image_viewer.repository

import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {

    fun getImageData(): Flow<String>

    suspend fun saveImageData(data: String)
}