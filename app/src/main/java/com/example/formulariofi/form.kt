package com.example.formulariofi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulariofi.databinding.ActivityFormBinding

class form : AppCompatActivity() {

    private lateinit var binding : ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}