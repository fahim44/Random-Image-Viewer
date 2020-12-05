package com.lamonjush.random_image_viewer.utility

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import timber.log.Timber
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class BitmapMapperImpl @Inject constructor() : BitmapMapper {

    override fun encodeToBase64(image: Bitmap): String {
        val outputStream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val b: ByteArray = outputStream.toByteArray()
        val imageEncoded: String = Base64.encodeToString(b, Base64.DEFAULT)
        Timber.d("image : %s", imageEncoded)
        return imageEncoded
    }

    override fun decodeBase64(input: String?): Bitmap {
        val decodedByte = Base64.decode(input, 0)
        return BitmapFactory
            .decodeByteArray(decodedByte, 0, decodedByte.size)
    }
}