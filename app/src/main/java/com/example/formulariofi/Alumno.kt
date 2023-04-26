package com.example.formulariofi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Alumno(
    val nombre: String?,
    val apellidos: String?,
    val birthdate: Int?,
    val correo: String?,
    val cuenta: String?,
    val carrera: String?
) : Parcelable {

}