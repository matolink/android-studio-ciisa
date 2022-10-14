package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //variables
        val categorias = findViewById<ImageButton>(R.id.categorias)
        val lista_tareas = findViewById<ImageButton>(R.id.lista_tareas)
        val configuraciones = findViewById<ImageButton>(R.id.configuraciones)
        val inicio_categorias = findViewById<TextView>(R.id.inicio_categorias)
        val inicio_lista = findViewById<TextView>(R.id.inicio_lista)
        val inicio_configuraciones = findViewById<TextView>(R.id.inicio_configuraciones)


        //eventos
        categorias.setOnClickListener {
            val intent = Intent(this@Inicio,Categorias::class.java)
            startActivity(intent)
        }

        lista_tareas.setOnClickListener {
            val intent = Intent(this@Inicio,Lista_tareas::class.java)
            startActivity(intent)
        }

        configuraciones.setOnClickListener {
            val intent = Intent(this@Inicio,Configuracion::class.java)
            startActivity(intent)
        }

        inicio_categorias.setOnClickListener {
            val intent = Intent(this@Inicio,Categorias::class.java)
            startActivity(intent)
        }

        inicio_lista.setOnClickListener {
            val intent = Intent(this@Inicio,Lista_tareas::class.java)
            startActivity(intent)
        }

        inicio_configuraciones.setOnClickListener {
            val intent = Intent(this@Inicio,Configuracion::class.java)
            startActivity(intent)
        }

    }
}