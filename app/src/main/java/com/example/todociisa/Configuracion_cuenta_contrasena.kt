package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Configuracion_cuenta_contrasena : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion_cuenta_contrasena)


        //variables

        val contrasena_guardar = findViewById<Button>(R.id.contrasena_guardar)
        val contrasena_cancelar = findViewById<Button>(R.id.contrasena_cancelar)
        val contrasena_nombre = findViewById<TextView>(R.id.contrasena_nombre)
        val contrasena_contacto = findViewById<TextView>(R.id.contrasena_contacto)


        //Eventos

        contrasena_guardar.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contrasena,Configuracion_cuenta::class.java)
            startActivity(intent)
        }

        contrasena_cancelar.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contrasena,Configuracion_cuenta::class.java)
            startActivity(intent)
        }

        contrasena_nombre.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contrasena,Configuracion_cuenta_nombre::class.java)
            startActivity(intent)
        }

        contrasena_contacto.setOnClickListener {
            val intent = Intent(this@Configuracion_cuenta_contrasena,Configuracion_cuenta_contacto::class.java)
            startActivity(intent)
        }
    }
}