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

        if(getYears() < 0){
            ok = false
            msg = resources.getString(R.string.campoFecha)

        }

        return Pair(ok, msg)
    }

    fun getYears() : Int {
        val today = Calendar.getInstance()
        return today.get(Calendar.YEAR) - (birthdate?.third ?: 25000000 )
    }

    fun getSigno() : Int {
        val month : Int? = birthdate?.second
        var day : Int? = birthdate?.first
        day = day ?: 0

        return when(month) {
            1 -> if (day >= 20) R.string.Acuario else R.string.Capricornio
            2 -> if (day >= 19) R.string.Piscis else R.string.Acuario
            3 -> if (day >= 21) R.string.Aries else R.string.Piscis
            4 -> if (day >= 20) R.string.Tauro else R.string.Aries
            5 -> if (day >= 21) R.string.Geminis else R.string.Tauro
            6 -> if (day >= 21) R.string.Cancer else R.string.Geminis
            7 -> if (day >= 23) R.string.Leo else R.string.Cancer
            8 -> if (day >= 23) R.string.Virgo else R.string.Leo
            9 -> if (day >= 23) R.string.Libra  else R.string.Virgo
            10 -> if (day >= 23) R.string.Escorpio else R.string.Libra
            11 -> if (day >= 22) R.string.Sagitario else R.string.Escorpio
            12 -> if (day >= 22) R.string.Capricornio else R.string.Sagitario
            else -> 0
        }
    }
}
