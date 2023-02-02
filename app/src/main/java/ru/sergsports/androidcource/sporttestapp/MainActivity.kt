package ru.sergsports.androidcource.sporttestapp

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import ru.sergsports.androidcource.sporttestapp.databinding.ActivityMainBinding
import ru.sergsports.androidcource.sporttestapp.presentation.mockview.MockNewsFragment

class MainActivity : AppCompatActivity() {


    lateinit var  binding: ActivityMainBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        //getActionBar()?.hide()

        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        /*val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        val mWebSettings = webActivity.settings
        mWebSettings.javaScriptEnabled = true
        mWebSettings.loadWithOverviewMode = true
        mWebSettings.useWideViewPort = true
        mWebSettings.domStorageEnabled = true
        mWebSettings.databaseEnabled = true
        mWebSettings.setSupportZoom(false)
        mWebSettings.allowFileAccess = true
        mWebSettings.allowContentAccess = true
        mWebSettings.loadWithOverviewMode = true
        mWebSettings.useWideViewPort = true*/

    }
    private fun init() {
        binding.apply {
            /*button.setOnClickListener { supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, MockNewsFragment())}*/
        }
    }
}