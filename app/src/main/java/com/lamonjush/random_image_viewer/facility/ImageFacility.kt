package com.lamonjush.random_image_viewer.facility

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow

interface ImageFacility {

    fun getImage() : Flow<Bitmap>

    fun putImage(bitmap: Bitmap)
}