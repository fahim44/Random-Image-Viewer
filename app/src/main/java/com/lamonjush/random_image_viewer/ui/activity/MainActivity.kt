package com.lamonjush.random_image_viewer.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lamonjush.random_image_viewer.R
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
        //todo
    }

    private fun handleClickListener() {
        binding.fetchImageButton.setOnClickListener {
            //todo
        }
    }
}