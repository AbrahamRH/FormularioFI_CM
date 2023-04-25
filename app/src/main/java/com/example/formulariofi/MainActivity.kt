package com.example.formulariofi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var btnNewProfile = findViewById<Button>(R.id.btnNewProfile)
    fun newProfile(view: View) {

    }
}