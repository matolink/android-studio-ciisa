package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Configuracion_cuenta_contacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion_cuenta_contacto)

        //variables

        val contacto_cancelar = findViewById<Button>(R.id.contrasena_cancelar)
        val contacto_guardar = findViewById<Button>(R.id.contrasena_guardar)
        val contacto_contraseña = findViewById<TextView>(R.id.contacto_contraseña)
        val contacto_nombre = findViewById<TextView>(R.id.contrasena_nombre)


        //Eventos

        contacto_cancelar.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contacto,Configuracion_cuenta::class.java)
            startActivity(intent)
        }

        contacto_guardar.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contacto,Configuracion_cuenta::class.java)
            startActivity(intent)
        }

        contacto_contraseña.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contacto, Configuracion_cuenta_contrasena::class.java)
            startActivity(intent)

        }

        contacto_nombre.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contacto,Configuracion_cuenta_nombre::class.java)
            startActivity(intent)
        }

    }
}