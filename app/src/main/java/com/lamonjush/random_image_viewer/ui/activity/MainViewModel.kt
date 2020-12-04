package com.lamonjush.random_image_viewer.ui.activity

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.lamonjush.random_image_viewer.facility.ImageFacility
import dagger.hilt.android.qualifiers.ApplicationContext

class MainViewModel @ViewModelInject constructor(
    @ApplicationContext private val context: Context,
    facility: ImageFacility
) : ViewModel() {
}