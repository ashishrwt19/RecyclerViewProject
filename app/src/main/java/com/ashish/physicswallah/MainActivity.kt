package com.ashish.physicswallah

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ashish.physicswallah.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MainFragment())
                .commitAllowingStateLoss()
        }
        binding.backButton.setOnClickListener {
            finish()
        }

    }
}