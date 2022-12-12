package com.example.todociisa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Categoria
import roomDatabase.entity.Tarea
import java.util.ArrayList

class Lista_tareas : AppCompatActivity() {
    private var cats: List<Categoria> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tareas)

        getCategories()

        //variables

        val tarea_add = findViewById<ImageButton>(R.id.add_tarea_button)
        val tarea_edit = findViewById<ImageButton>(R.id.tarea_edit)
        val tarea_pedit = findViewById<ImageButton>(R.id.tarea_pedit)
        var cats_datos_list = findViewById<Spinner>(R.id.sp_category)

        if (cats_datos_list != null) {
            cats_datos_list.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    getTareasByCategory(cats[position].id)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Handler(Looper.getMainLooper()).post {
                        Toast.makeText(
                            this@Lista_tareas,
                            "Por favor seleccione una categoría",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

        //Eventos

        tarea_add.setOnClickListener {
            val selected_cat_id: String = cats_datos_list.getSelectedItem().toString()

            val intent = Intent(this@Lista_tareas,Nueva_tarea::class.java)
            intent.putExtra("catID",selected_cat_id);
            startActivity(intent)
        }

        //tarea_edit.setOnClickListener {
        //    val intent = Intent(this@Lista_tareas, Editar_tarea::class.java)
        //    startActivity(intent)
        //}

        //tarea_pedit.setOnClickListener {
        //    val intent = Intent(this@Lista_tareas,Editar_tarea::class.java)
        //    startActivity(intent)
        //}

//        lv_datos.onItemClickListener = object : AdapterView.OnItemClickListener{
//            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                Toast.makeText(this@Lista_tareas,"Escogido ${recetas[position]}", Toast.LENGTH_LONG).show()
//            }
//        }
    }

    private fun getCategories() {

        CoroutineScope(Dispatchers.IO).launch {
            val db = Room.databaseBuilder(
                applicationContext,
                Db::class.java, "database-name"
            ).build()

            cats = db.daoCategoria().obtenerCategoria()
            onResult(cats)
        }

    }

    private fun onResult(cats: List<Categoria>) {
        var cats_datos_list = findViewById<Spinner>(R.id.sp_category)

        val cat_names = cats.map { it.nombre }
//        if(!cat_names.isEmpty()) {
//            getTareasByCategory(cat_names[0]!!)
//        }

        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,R.layout.elemento_de_lista, cat_names)

        cats_datos_list.adapter = arrayAdapter
    }

    private fun getTareasByCategory(cat_name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val db = Room.databaseBuilder(
                applicationContext,
                Db::class.java, "database-name"
            ).build()

            val tareas = db.daoTarea().obtenerTareaByCategory(cat_name)
            onResultTareas(tareas)
        }
    }

    private fun onResultTareas(tareas: List<Tarea>) {
        var lv_datos = findViewById<ListView>(R.id.lv_datos)
        val tareas_names = tareas.map { it.tarea }

        val arrayAdapter: ListAdapter
        arrayAdapter = ListAdapter(this, tareas as ArrayList<Tarea>?)
        Handler(Looper.getMainLooper()).post {
            lv_datos.adapter = arrayAdapter
        }

    }
}