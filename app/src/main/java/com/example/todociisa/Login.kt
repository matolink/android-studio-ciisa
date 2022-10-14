package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //variables
        val login_btn_register = findViewById<TextView>(R.id.login_btn_register)
        val login_btn_login = findViewById<TextView>(R.id.login_btn_login)


        //Eventos
        login_btn_register.setOnClickListener {
            val intent = Intent(this@Login,Nueva_Cuenta::class.java)
            startActivity(intent)
        }
        login_btn_login.setOnClickListener {
            val intent = Intent(this@Login,Inicio::class.java)
            startActivity(intent)
        }
    }
}