package com.example.ad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ad.databinding.ActivityMainBinding
import com.example.ad.presentation.VideoFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = VideoFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainer.id, fragment)
            .commit()
    }
}