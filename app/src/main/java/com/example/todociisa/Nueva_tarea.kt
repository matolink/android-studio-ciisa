package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import com.example.todociisa.utils.Utilidades
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Categoria
import roomDatabase.entity.Tarea
import java.text.SimpleDateFormat
import java.util.*

class Nueva_tarea : AppCompatActivity() {
    var catID:String = ""
    private var tarea_name: TextInputLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_tarea)

        catID = intent.extras?.getString("catID").toString()

        //variables

        val nueva_aceptar = findViewById<Button>(R.id.agregar_categoria)

        //Evento

        nueva_aceptar.setOnClickListener {
            tarea_name = findViewById<TextInputLayout>(R.id.tarea_name)
            val tarea_name_text = tarea_name?.editText?.text.toString()
            val utilidades = Utilidades()
            if(utilidades.validateNull(tarea_name_text, tarea_name)){
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())

                CoroutineScope(Dispatchers.IO).launch {
                    val db = Room.databaseBuilder(
                        applicationContext,
                        Db::class.java, "database-name"
                    ).build()

                    db.daoTarea().agregarTarea(Tarea(tarea_name_text, tarea_name_text, currentDate, catID, "prueba@gmail.com", true))
                    onResult()
                }
            }
        }
    }

    private fun onResult() {
        val intent =  Intent(this@Nueva_tarea,Lista_tareas::class.java)
        startActivity(intent)
    }
}