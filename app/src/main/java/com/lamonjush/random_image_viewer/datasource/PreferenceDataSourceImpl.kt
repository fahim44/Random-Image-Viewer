package com.lamonjush.random_image_viewer.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.lamonjush.random_image_viewer.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PreferenceDataSource {

    private val dataStore: DataStore<Preferences> =
        context.createDataStore(BuildConfig.preferenceStore_name)

    override fun get(key: String): Flow<String> {
        val prefKey = preferencesKey<String>(key)
        return dataStore.data.map {
            it[prefKey] ?: ""
        }
    }

    override suspend fun put(key: String, value: String) {
        val prefKey = preferencesKey<String>(key)
        dataStore.edit {
            it[prefKey] = value
        }
    }
}