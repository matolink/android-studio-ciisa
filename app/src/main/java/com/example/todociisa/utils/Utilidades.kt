package com.example.todociisa.utils

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout

class Utilidades {

    fun validateNull(validating: String, field: TextInputLayout?): Boolean{
        val value = !TextUtils.isEmpty(validating)
        if(!value){
            field?.error = "Este campo es obligatorio"
        }
        return value
    }

    fun validateEmail(email: String, field: TextInputLayout?): Boolean{
        val value = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if(!value){
            field?.error = "El valor ingresado debe ser un email válido"
        }
        return value
    }

}