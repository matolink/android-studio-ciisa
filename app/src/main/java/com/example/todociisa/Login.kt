package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login_btn_register = findViewById<TextView>(R.id.login_btn_register)
        login_btn_register.setOnClickListener {
            val intent = Intent(this@Login,Nueva_Cuenta::class.java)
            startActivity(intent)
        }
    }
}