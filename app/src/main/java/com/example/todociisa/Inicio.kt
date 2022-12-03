package com.example.todociisa

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val btn_foto = findViewById<Button>(R.id.btn_foto)
        btn_foto.setOnClickListener {
            val intentPhoto = MediaStore.ACTION_IMAGE_CAPTURE
            asignarFoto.launch(Intent(intentPhoto))
        }
    }

    private val asignarFoto = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
            result : ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.img_perfil)
            imageView.setImageBitmap(imageBitmap)
        }



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