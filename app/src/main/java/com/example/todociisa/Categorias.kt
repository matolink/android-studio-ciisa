package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Categoria

class Categorias : AppCompatActivity() {
    var cat_names: List<String> = listOf("Por favor crea al menos una categoría")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        //variables

        val categorias_agregar = findViewById<ImageButton>(R.id.categorias_agregar)

        CoroutineScope(Dispatchers.IO).launch {
            val db = Room.databaseBuilder(
                applicationContext,
                Db::class.java, "database-name"
            ).build()

            val cats = db.daoCategoria().obtenerCategoria()
            onResult(cats)
        }


        //Eventos

        categorias_agregar.setOnClickListener {
            val intent = Intent(this@Categorias,Nueva_categoria::class.java)
            startActivity(intent)
        }

    }

    private fun onResult(cats: List<Categoria>) {
        var cats_datos_list = findViewById<ListView>(R.id.cats_datos_list)

        if(!cats.isEmpty()) {
            cat_names = cats.map { it.nombre.toString() }
        }

        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,R.layout.elemento_de_lista, cat_names)

        cats_datos_list.adapter = arrayAdapter
    }
}