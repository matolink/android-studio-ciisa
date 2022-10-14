package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Editar_tarea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_tarea)

        //variables

        val tarea_editar = findViewById<Button>(R.id.agregar_categoria)


        //evento

        tarea_editar.setOnClickListener {
            val intent = Intent(this@Editar_tarea,Categoria_personal::class.java)
            startActivity(intent)
        }
    }
}