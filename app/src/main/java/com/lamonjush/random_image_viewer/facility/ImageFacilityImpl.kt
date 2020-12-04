package com.lamonjush.random_image_viewer.facility

import android.graphics.Bitmap
import com.lamonjush.random_image_viewer.repository.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageFacilityImpl @Inject constructor(
    repository: PreferenceRepository
) : ImageFacility {

    override fun getImage(): Flow<Bitmap> {
        TODO("Not yet implemented")
    }

    override fun putImage(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }
}