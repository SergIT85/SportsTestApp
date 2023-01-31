package ru.sergsports.androidcource.sporttestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sergsports.androidcource.sporttestapp.databinding.ActivityMainBinding
import ru.sergsports.androidcource.sporttestapp.presentation.mockview.MockNewsFragment

class MainActivity : AppCompatActivity() {


    lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //setContentView(R.layout.mock_fragment)
        //init()
        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView, MockNewsFragment())
        transaction.commit()*/
    }
    private fun init() {
        binding.apply {
            button.setOnClickListener { supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, MockNewsFragment())}
        }
    }
}