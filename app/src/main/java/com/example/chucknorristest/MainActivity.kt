package com.example.chucknorristest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorristest.databinding.ActivityMainBinding
import com.example.chucknorristest.view.SingleJokeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnSingleJoke.setOnClickListener { openSingleJokeFragment() }
    }

    private fun openSingleJokeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SingleJokeFragment())
            .commit()
    }
}