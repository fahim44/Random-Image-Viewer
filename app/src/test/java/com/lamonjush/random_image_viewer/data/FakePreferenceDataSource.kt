package com.lamonjush.random_image_viewer.data

import com.lamonjush.random_image_viewer.datasource.PreferenceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePreferenceDataSource(private val images: MutableMap<String, String>) : PreferenceDataSource {
    override fun get(key: String): Flow<String> {
        return flow {
            emit(images[key] ?: "")
        }
    }

    override suspend fun put(key: String, value: String) {
        images[key] = value
    }
}