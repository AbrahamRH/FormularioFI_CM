package com.example.formulariofi

import android.annotation.SuppressLint
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
                putContent(alumno)
            }
        }
    }

    private fun putContent(alumno : Alumno) {
        binding.tvNombreCompleto.text = getString(R.string.nombreCompleto, alumno.nombre, alumno.apellidos)
        binding.tvCarrera.text = alumno.carrera
        binding.tvEdad.text = alumno.birthdate
        binding.tvCorreo.text = alumno.correo
    }
}