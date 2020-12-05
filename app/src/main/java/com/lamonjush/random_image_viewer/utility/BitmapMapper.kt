package com.lamonjush.random_image_viewer.utility

import android.graphics.Bitmap

interface BitmapMapper {

    fun encodeToBase64(image: Bitmap): String

    fun decodeBase64(input: String?): Bitmap
}