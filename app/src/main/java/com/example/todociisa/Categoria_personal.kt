package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Categoria_personal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_personal)


        //variables

        val personal_agregar = findViewById<ImageButton>(R.id.personal_agregar)
        val editar = findViewById<ImageButton>(R.id.tarea_edit)

        personal_agregar.setOnClickListener {
            val intent = Intent(this@Categoria_personal,Nueva_tarea::class.java)
            startActivity(intent)
        }

        editar.setOnClickListener {
            val intent = Intent(this@Categoria_personal,Editar_tarea::class.java)
            startActivity(intent)
        }
    }
}