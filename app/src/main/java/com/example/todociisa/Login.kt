package com.example.todociisa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.todociisa.utils.Utilidades
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Usuario

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
            val email_text = email?.editText?.text.toString()
            val pass_text = pass?.editText?.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val db = Room.databaseBuilder(
                    applicationContext,
                    Db::class.java, "database-name"
                ).build()

                val users = db.daoUsuario().login(email_text, pass_text)
                onResult(users)
            }
        }
    }

    fun validateForm(): Boolean{
        val email_text = email?.editText?.text.toString()
        val pass_text = pass?.editText?.text.toString()

        val utilidades = Utilidades()

        return  utilidades.validateEmail(email_text, email) and
                utilidades.validateNull(pass_text, pass)
    }

    private fun onResult(users: List<Usuario>) {
        if(users.isEmpty()){
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(this@Login,"Usuario o Contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }
        else{
            val intent = Intent(this@Login,Inicio::class.java)
            startActivity(intent)
        }
    }
}