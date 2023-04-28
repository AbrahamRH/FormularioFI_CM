package com.example.formulariofi

import android.content.res.Resources
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Alumno(
    val nombre: String?,
    val apellidos: String?,
    val birthdate: Triple<Int,Int,Int>?,
    val correo: String?,
    val cuenta: String?,
    val carrera: String?
) : Parcelable {

    fun check(): Boolean {
        var isComplete = true
        if (nombre.equals("") || apellidos.equals("") || correo.equals("") || cuenta.equals("") || carrera.equals("")) {
            isComplete = false
        }
        if ((birthdate?.first ?: 0) == (birthdate?.second ?: 0) && (birthdate?.second
                ?: 0) == (birthdate?.third ?: 0)
        ){
            isComplete = false
        }
        return isComplete
    }

    fun checkAttributes(resources : Resources): Pair<Boolean, String> {
        var ok = true
        var msg = ""
        if (cuenta?.length != 9) {
            ok = false
            msg = resources.getString(R.string.campoCuenta)
        }
        if (carrera.equals("None")) {
            ok = false
            msg = resources.getString(R.string.campoCarrera)
        }

        if(getYears() <= 0){
            ok = false
            msg = resources.getString(R.string.campoFecha)

        }

        return Pair(ok, msg)
    }

    fun getYears() : Int {
        val today = Calendar.getInstance()
        return today.get(Calendar.YEAR) - (birthdate?.third ?: 25000000 )
    }
}
