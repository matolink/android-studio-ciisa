package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Categorias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        //variables

        val categorias_trabajo = findViewById<Button>(R.id.categoria_trabajo)
        val categorias_agregar = findViewById<ImageButton>(R.id.categorias_agregar)


        //Eventos
        categorias_trabajo.setOnClickListener {
            val intent = Intent(this@Categorias,Categoria_personal::class.java)
            startActivity(intent)
        }

        categorias_agregar.setOnClickListener {
            val intent = Intent(this@Categorias,Nueva_categoria::class.java)
            startActivity(intent)
        }

    }
}