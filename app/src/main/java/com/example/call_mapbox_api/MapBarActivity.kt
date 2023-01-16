package com.example.call_mapbox_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.call_mapbox_api.databinding.ActivityMapBarBinding

class MapBarActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMapBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        println("het eddig")
        binding.searchBarActivity.inputSearch.setOnClickListener{
            println("clicked naaaaaaaa")
        }
    }
}
