package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.todociisa.utils.Utilidades
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
		private var email: TextInputLayout? = null
		private var pass: TextInputLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
				this.setLayouts()
				this.setClickListenners()
        val btn_map = findViewById<Button>(R.id.btn_map)
        btn_map.setOnClickListener{
            startActivity(
                Intent(this,
                    gpsActivity::class.java))
        }
    }

    fun setLayouts(){
        email = findViewById<TextInputLayout>(R.id.login_til_user)
        pass = findViewById<TextInputLayout>(R.id.login_til_pass)
    }

    fun setClickListenners(){
			val login_btn_register = findViewById<TextView>(R.id.login_btn_register)
			val login_btn_login = findViewById<TextView>(R.id.login_btn_login)
			login_btn_register.setOnClickListener {
					val intent = Intent(this@Login,Nueva_Cuenta::class.java)
					startActivity(intent)
			}
			login_btn_login.setOnClickListener {
				this.onLoginButtonClick()
			}
    }

    fun onLoginButtonClick(){
        if(validateForm()){
					val intent = Intent(this@Login,Inicio::class.java)
					startActivity(intent)
        }
    }

    fun validateForm(): Boolean{
        val email_text = email?.editText?.text.toString()
        val pass_text = pass?.editText?.text.toString()

        val utilidades = Utilidades()

        return  utilidades.validateEmail(email_text, email) and
                utilidades.validateNull(pass_text, pass)
    }
}