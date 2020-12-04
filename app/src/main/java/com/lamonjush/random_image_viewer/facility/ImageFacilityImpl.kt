package com.lamonjush.random_image_viewer.facility

import com.lamonjush.random_image_viewer.repository.PreferenceRepository
import javax.inject.Inject

class ImageFacilityImpl @Inject constructor(
    repository: PreferenceRepository
) : ImageFacility {
}