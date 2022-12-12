package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import com.example.todociisa.utils.Utilidades
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Categoria
import roomDatabase.entity.Usuario

class Nueva_categoria : AppCompatActivity() {
    private var category_name: TextInputLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_categoria)

        //variables

        val agregar_cateforia = findViewById<Button>(R.id.agregar_categoria)
        category_name = findViewById<TextInputLayout>(R.id.category_name)

        //Eventos
        agregar_cateforia.setOnClickListener {
            val category_name_text = category_name?.editText?.text.toString()
            val utilidades = Utilidades()
            if(utilidades.validateNull(category_name_text, category_name)){

                CoroutineScope(Dispatchers.IO).launch {
                    val db = Room.databaseBuilder(
                        applicationContext,
                        Db::class.java, "database-name"
                    ).build()

                    db.daoCategoria().agregarCategoria(Categoria(category_name_text, category_name_text, "prueba@gmail.com"))
                    onResult()
                }
            }
        }
    }

    private fun onResult() {
        val intent = Intent(this@Nueva_categoria,Categorias::class.java)
        startActivity(intent)
    }
}