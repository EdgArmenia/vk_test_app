package com.example.vktestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vktestpractice.databinding.ActivityMainBinding
import com.example.vktestpractice.fragments.FirstFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = FirstFragment.newInstance()

            // Set first fragment on activity
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment).commit()
        }
    }
}