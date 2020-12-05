package com.lamonjush.random_image_viewer.repository

import MainCoroutineRule
import com.lamonjush.random_image_viewer.data.FakePreferenceDataSource
import com.lamonjush.random_image_viewer.datasource.PreferenceDataSource
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
class PreferenceRepositoryImplTest : TestCase() {

    private val lastShownImages = mutableMapOf(Pair("RANDOM_IMAGE_KEY", "image1"))
    private lateinit var fakeDataSource: PreferenceDataSource
    private lateinit var repository: PreferenceRepository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    public override fun setUp() {
        fakeDataSource = FakePreferenceDataSource(lastShownImages)
        repository = PreferenceRepositoryImpl(fakeDataSource)
    }

    fun testGetImageData() = mainCoroutineRule.runBlockingTest {
        val imageUrl = repository.getImageData().first()
        assertThat(imageUrl, IsEqual("image1"))
    }

    fun testSaveImageData() = mainCoroutineRule.runBlockingTest{
        repository.saveImageData("image2")
        val imageUrl = repository.getImageData().first()
        assertThat(imageUrl, IsEqual("image2"))
    }
}