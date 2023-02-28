package com.example.vktestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.vktestpractice.databinding.ActivityMainBinding
import com.example.vktestpractice.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = FirstFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment).commit()
        }


//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, FirstFragment::class)
    }
}