package com.example.formulariofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formulariofi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayCarreras : ArrayAdapter<CharSequence>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSpinner()
    }

    fun setSpinner() {
        arrayCarreras = ArrayAdapter.createFromResource(
            this, R.array.careers_array,
            android.R.layout.simple_spinner_item
        )
        binding.spinnerCarrera.adapter = arrayCarreras
        binding.spinnerCarrera.onItemSelectedListener = this
    }

    fun newProfile(view: View) {
        val intent = Intent(this, form::class.java)
        startActivity(intent)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}