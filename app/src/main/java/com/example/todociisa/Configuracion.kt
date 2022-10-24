package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        //variables

        val configuracion_cuenta = findViewById<TextView>(R.id.contrasena_nombre)

        //Evento

        configuracion_cuenta.setOnClickListener {
            val intent = Intent(this@Configuracion,Configuracion_cuenta::class.java)
            startActivity(intent)
        }
    }
}