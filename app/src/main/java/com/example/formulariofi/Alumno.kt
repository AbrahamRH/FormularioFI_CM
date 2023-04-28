package com.example.formulariofi

import android.content.res.Resources
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Alumno(
    val nombre: String?,
    val apellidos: String?,
    val birthdate: String?,
    val correo: String?,
    val cuenta: String?,
    val carrera: String?
) : Parcelable {

    fun check(): Boolean {
        var isComplete = true
        if (nombre.equals("") || apellidos.equals("") || birthdate.equals("") || correo.equals("") || cuenta.equals("") || carrera.equals("")) {
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

        return Pair(ok, msg)
    }
}
