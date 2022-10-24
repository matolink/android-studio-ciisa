package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Nueva_tarea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_tarea)

        //variables

        val nueva_aceptar = findViewById<Button>(R.id.agregar_categoria)

        //Evento

        nueva_aceptar.setOnClickListener {
            val intent =  Intent(this@Nueva_tarea,Categoria_personal::class.java)
            startActivity(intent)
        }
    }
}