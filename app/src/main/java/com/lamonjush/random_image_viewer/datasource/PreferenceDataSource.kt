package com.lamonjush.random_image_viewer.datasource

import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {

    fun get(key: String): Flow<String>

    suspend fun put(key: String, value: String)
}