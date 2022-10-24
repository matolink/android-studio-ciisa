package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Nueva_categoria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_categoria)

        //variables

        val agregar_cateforia = findViewById<Button>(R.id.agregar_categoria)

        //Eventos
        agregar_cateforia.setOnClickListener {
            val intent = Intent(this@Nueva_categoria,Categorias::class.java)
            startActivity(intent)
        }
    }
}