package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Nueva_Cuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_cuenta)

        // variables
        val nueva_cuenta_cancelar = findViewById<Button>(R.id.nueva_cuenta_cancelar)
        val nueva_cuenta_crear = findViewById<Button>(R.id.nueva_cuenta_crear)

        //eventos
        nueva_cuenta_cancelar.setOnClickListener {
          val intent = Intent(this@Nueva_Cuenta,Login::class.java)
            startActivity(intent)
        }

        nueva_cuenta_crear.setOnClickListener{
            val intent = Intent(this@Nueva_Cuenta,Inicio::class.java)
            startActivity(intent)
        }


    }
}