package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Configuracion_cuenta_nombre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion_cuenta_nombre)

        //variables

        val nombre_guardar = findViewById<Button>(R.id.contrasena_guardar)
        val nombre_cancelar = findViewById<Button>(R.id.contrasena_cancelar)
        val nombre_contacto = findViewById<TextView>(R.id.contrasena_contacto)
        val nombre_contraseña = findViewById<TextView>(R.id.contacto_contraseña)


        //Eventos

        nombre_guardar.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_nombre,Configuracion_cuenta::class.java)
            startActivity(intent)
        }

        nombre_cancelar.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_nombre,Configuracion_cuenta::class.java)
            startActivity(intent)
        }

        nombre_contacto.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_nombre,Configuracion_cuenta_contacto::class.java)
            startActivity(intent)
        }

        nombre_contraseña.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_nombre,Configuracion_cuenta_contrasena::class.java)
            startActivity(intent)
        }

    }
}