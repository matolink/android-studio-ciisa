package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Configuracion_cuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion_cuenta)

        //variables

        val nombre_usuario = findViewById<TextView>(R.id.contrasena_nombre)
        val contraseña = findViewById<TextView>(R.id.contacto_contraseña)
        val contacto = findViewById<TextView>(R.id.contrasena_contacto)


        //Evantos

        nombre_usuario.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta,Configuracion_cuenta_nombre::class.java)
            startActivity(intent)
        }

        contraseña.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta,Configuracion_cuenta_contrasena::class.java)
            startActivity(intent)
        }

        contacto.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta,Configuracion_cuenta_contacto::class.java)
            startActivity(intent)
        }

    }
}