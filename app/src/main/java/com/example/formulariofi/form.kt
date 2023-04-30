package com.example.formulariofi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.formulariofi.databinding.ActivityFormBinding

class form : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    private val arrayImgCarreras  = setArrayCarreras()
    private var imgId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setArrayCarreras()
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {
            val alumno = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU ){
                bundle.getParcelable("Alumno", Alumno::class.java)
            } else {
                bundle.getParcelable("Alumno")
            }
            imgId = bundle.getInt("imgId")

            if (alumno != null) {
                putContent(alumno)
            }
        }
    }

    private fun putContent(alumno : Alumno) {
        Log.d("Debug", "imagen: $imgId Con id: ${arrayImgCarreras[imgId]}")
        binding.tvNombreCompleto.text = getString(R.string.nombreCompleto, alumno.nombre, alumno.apellidos)
        binding.imgCarrera.setImageResource(arrayImgCarreras[imgId])
        binding.tvEdad.text = alumno.getYears().toString()
        binding.tvCorreo.text = alumno.correo
        binding.tvSignoZodiacal.text = getString(alumno.getSigno())
    }

    private fun setArrayCarreras() : ArrayList<Int> {
        val arrayImgCarreras =  ArrayList<Int>(16)
        arrayImgCarreras.add(0)
        arrayImgCarreras.add(R.drawable.ing_espacial)
        arrayImgCarreras.add(R.drawable.ing_civil)
        arrayImgCarreras.add(R.drawable.ing_geomatica)
        arrayImgCarreras.add(R.drawable.ing_ambiental)
        arrayImgCarreras.add(R.drawable.ing_geofisica)
        arrayImgCarreras.add(R.drawable.ing_geologica)
        arrayImgCarreras.add(R.drawable.ing_petrolera)
        arrayImgCarreras.add(R.drawable.ing_minas)
        arrayImgCarreras.add(R.drawable.ing_computacion)
        arrayImgCarreras.add(R.drawable.ing_electrica)
        arrayImgCarreras.add(R.drawable.ing_telecomunicaciones)
        arrayImgCarreras.add(R.drawable.ing_mecanica)
        arrayImgCarreras.add(R.drawable.ing_industrial)
        arrayImgCarreras.add(R.drawable.ing_mecatronica)
        arrayImgCarreras.add(R.drawable.ing_biomedica)
        return arrayImgCarreras
    }
}