package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Lista_tareas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tareas)

        //variables

        val tarea_add = findViewById<ImageButton>(R.id.tarea_add)
        val tarea_edit = findViewById<ImageButton>(R.id.tarea_edit)
        val tarea_pedit = findViewById<ImageButton>(R.id.tarea_pedit)

        //Eventos

        tarea_add.setOnClickListener {
            val intent = Intent(this@Lista_tareas,Nueva_tarea::class.java)
            startActivity(intent)
        }

        tarea_edit.setOnClickListener {
            val intent = Intent(this@Lista_tareas, Editar_tarea::class.java)
            startActivity(intent)
        }

        tarea_pedit.setOnClickListener {
            val intent = Intent(this@Lista_tareas,Editar_tarea::class.java)
            startActivity(intent)
        }
    }
}