package com.lamonjush.random_image_viewer.datasource

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PreferenceDataSource {
}