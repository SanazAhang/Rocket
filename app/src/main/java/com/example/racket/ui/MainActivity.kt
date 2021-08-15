package com.example.racket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.racket.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: RocketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observer()
    }

    private fun observer() {

        viewModel.rocket.observe(this, Observer {
            Log.d("Data", it.toString())
        })

        viewModel.error.observe(this, Observer { error ->
            error.message?.let {
                    it -> Log.d("error", it)
            }
        })

        viewModel.failure.observe(this, Observer { message ->
            Log.d("failure",message)
        })

        viewModel.loading.observe(this, Observer { })

    }
}