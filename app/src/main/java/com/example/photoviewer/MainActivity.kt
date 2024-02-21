package com.example.photoviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.photoviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var index = 1
    val images:List<Int> = listOf(
        R.drawable.aurora,
        R.drawable.beach1,
        R.drawable.beach2,
        R.drawable.church,
        R.drawable.motorbike
    )
    val number_of_images = images.size
    var image = images[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.imageViewChangingImage.setImageResource(image)
        binding.textViewImageNumber.text = getString(R.string.imageNumber, index, number_of_images)

        binding.buttonNext.setOnClickListener{
            index++
            if (index > number_of_images) {
                index = 1
            }
            changeImage()
        }

        binding.buttonPrevious.setOnClickListener{
            index--
            if (index < 1) {
                index = number_of_images
            }
            changeImage()
        }
    }

    fun changeImage() {
        image = images[index-1]
        binding.imageViewChangingImage.setImageResource(image)
        binding.textViewImageNumber.text = getString(R.string.imageNumber, index, number_of_images)

    }
}