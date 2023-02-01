package ru.sergsports.androidcource.sporttestapp

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sergsports.androidcource.sporttestapp.databinding.ActivityMainBinding
import ru.sergsports.androidcource.sporttestapp.presentation.mockview.MockNewsFragment

class MainActivity : AppCompatActivity() {


    lateinit var  binding: ActivityMainBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
    private fun init() {
        binding.apply {
            /*button.setOnClickListener { supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, MockNewsFragment())}*/
        }
    }
}