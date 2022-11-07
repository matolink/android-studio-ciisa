package com.example.todociisa.utils

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utilidades {

    fun validateNull(validating: String, field: TextInputLayout?): Boolean{
        val value = !TextUtils.isEmpty(validating.trim())
        if(!value){
            field?.error = "Este campo es obligatorio"
        }
        else{
            field?.error = null
        }
        return value
    }

    fun validateEmail(email: String, field: TextInputLayout?): Boolean{
        val value = !TextUtils.isEmpty(email.trim()) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if(!value){
            field?.error = "El valor ingresado debe ser un email válido"
        }
        else{
            field?.error = null
        }
        return value
    }

    fun validateDate(dateStr: String, field: TextInputLayout?): Boolean{
        var formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        try {
            formatter.parse(dateStr)
            field?.error = null
        } catch (e: ParseException) {
            field?.error = "Por favor verifica la fecha seleccionada"
            return false
        }
        return true
    }

}