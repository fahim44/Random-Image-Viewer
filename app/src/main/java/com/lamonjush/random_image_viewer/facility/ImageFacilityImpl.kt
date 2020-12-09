package com.lamonjush.random_image_viewer.facility

import android.graphics.Bitmap
import com.lamonjush.random_image_viewer.repository.PreferenceRepository
import com.lamonjush.random_image_viewer.utility.BitmapMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class ImageFacilityImpl @Inject constructor(
    private val repository: PreferenceRepository,
    private val mapper: BitmapMapper
) : ImageFacility {

    override fun getImage(): Flow<Bitmap> {
        return repository.getImageData()
            .filter { it.trim().isNotEmpty() }
            .map { mapper.decodeBase64(it) }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun putImage(bitmap: Bitmap) {
        repository.saveImageData(mapper.encodeToBase64(bitmap))
    }
}