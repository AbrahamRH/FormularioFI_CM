package com.example.formulariofi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.formulariofi.databinding.ActivityFormBinding

class form : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if (bundle != null) {
            val alumno = bundle.getParcelable("Alumno", Alumno::class.java)
            if (alumno != null) {
                Toast.makeText(
                    this,
                    " Los datos del alumno son: ${alumno.nombre} ${alumno.apellidos} ${alumno.carrera}",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Alumno nulo",
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            Toast.makeText(
                this,
                "Bundle nulo",
                Toast.LENGTH_LONG
            ).show()

        }

    }
}