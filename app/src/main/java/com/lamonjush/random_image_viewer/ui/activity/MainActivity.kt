package com.lamonjush.random_image_viewer.ui.activity

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.signature.ObjectKey
import com.lamonjush.random_image_viewer.BuildConfig
import com.lamonjush.random_image_viewer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleLiveData()
        handleClickListener()
    }

    private fun handleLiveData() {
        viewModel.netWorkAvailableLiveData.observe(this, {
            if (it) {
                binding.noNetworkAlertCardView.visibility = View.INVISIBLE
            } else {
                binding.noNetworkAlertCardView.visibility = View.VISIBLE
            }
        })

        viewModel.bitmapLiveData.observe(this, {
            binding.imageView.setImageBitmap(it)
        })
    }

    private fun handleClickListener() {
        binding.fetchImageButton.setOnClickListener {
            if (viewModel.canFetchImage()) {
                fetchImage()
            }
        }
    }

    private fun fetchImage() {
        Glide.with(this)
            .asBitmap()
            .load(BuildConfig.imageFetch_url)
            .apply(RequestOptions().signature(ObjectKey("signature string")))
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) =
                    viewModel.imageFetched(resource)

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })
    }
}