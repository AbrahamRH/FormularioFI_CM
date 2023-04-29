package com.example.formulariofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formulariofi.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayCarreras: ArrayAdapter<CharSequence>

    private var imgId = 0
    private var nombreIn = ""
    private var apellidosIn = ""
    private var correoIn = ""
    private var cuentaIn = ""
    private var carreraIn = ""
    private var fechaNacIn = Triple(0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSpinner()
        setDatePicker()
    }
    private fun setSpinner() {
        arrayCarreras = ArrayAdapter.createFromResource(
            this, R.array.careers_array,
            android.R.layout.simple_spinner_item
        )
        binding.spinnerCarrera.adapter = arrayCarreras
        binding.spinnerCarrera.onItemSelectedListener = this
    }

    private fun setDatePicker() {
        val today = Calendar.getInstance()
        binding.inputFechaNacimiento.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val newMonth = month + 1
            fechaNacIn = Triple(day, newMonth, year)
        }
    }
    fun newProfile(view: View) {
        nombreIn = binding.inputNombre.text.toString()
        apellidosIn = binding.inputApellidos.text.toString()
        correoIn = binding.inputEmail.text.toString()
        cuentaIn = binding.inputCuenta.text.toString()

        val alumno = Alumno(nombreIn, apellidosIn, fechaNacIn, correoIn, cuentaIn, carreraIn)
        if (alumno.check()) {
            val (isOk, errorMsg) = alumno.checkAttributes(resources)
            if (isOk) {
                val intent = Intent(this, form::class.java)
                val bundle = Bundle()
                bundle.putParcelable("Alumno", alumno)
                bundle.putInt("imgId", imgId)
                intent.putExtras(bundle)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    errorMsg,
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            Toast.makeText(
                this,
                getString(R.string.completarFormulario),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        carreraIn = arrayCarreras.getItem(pos).toString()
        imgId = pos
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}


