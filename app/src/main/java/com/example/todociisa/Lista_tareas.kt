package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Lista_tareas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tareas)

        //variables

        val tarea_add = findViewById<ImageButton>(R.id.tarea_add)
        val tarea_edit = findViewById<ImageButton>(R.id.tarea_edit)
        val tarea_pedit = findViewById<ImageButton>(R.id.tarea_pedit)

        //Eventos

        // tarea_add.setOnClickListener {
        //    val intent = Intent(this@Lista_tareas,Nueva_tarea::class.java)
        //    startActivity(intent)
        //}

        //tarea_edit.setOnClickListener {
        //    val intent = Intent(this@Lista_tareas, Editar_tarea::class.java)
        //    startActivity(intent)
        //}

        //tarea_pedit.setOnClickListener {
        //    val intent = Intent(this@Lista_tareas,Editar_tarea::class.java)
        //    startActivity(intent)
        //}

        var lv_datos = findViewById<ListView>(R.id.lv_datos)

        val arrayAdapter: ArrayAdapter<*>
        val recetas = arrayOf("Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5")
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, recetas)

        lv_datos.adapter = arrayAdapter

        lv_datos.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@Lista_tareas,"Escogido ${recetas[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}