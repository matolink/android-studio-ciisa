package com.example.todociisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.todociisa.utils.Utilidades
import com.google.android.material.textfield.TextInputLayout

class Nueva_Cuenta : AppCompatActivity() {

    private var username: TextInputLayout? = null
    private var email: TextInputLayout? = null
    private var email_confirmation: TextInputLayout? = null
    private var password: TextInputLayout? = null
    private var password_confirmation: TextInputLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_cuenta)
        this.setClickListenners()
        this.setLayouts()
    }

    fun setLayouts(){
        username = findViewById<TextInputLayout>(R.id.textInputLayout6)
        email = findViewById<TextInputLayout>(R.id.textInputLayout9)
        email_confirmation = findViewById<TextInputLayout>(R.id.textInputLayout7)
        password = findViewById<TextInputLayout>(R.id.textInputLayout5)
        password_confirmation = findViewById<TextInputLayout>(R.id.textInputLayout8)
    }

    fun setClickListenners(){
        val button = findViewById<Button>(R.id.button5)
        button.setOnClickListener{
            this.onCreateButtonClick()
        }
        val cancelButton = findViewById<Button>(R.id.button6)
        cancelButton.setOnClickListener{
            finish()
        }
    }

    fun onCreateButtonClick(){
        if(validateForm()){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    fun validateForm(): Boolean{
        val username_text = username?.editText?.text.toString()
        val email_text = email?.editText?.text.toString()
        val email_confirmation_text = email_confirmation?.editText?.text.toString()
        val password_text = password?.editText?.text.toString()
        val password_confirmation_text = password_confirmation?.editText?.text.toString()

        val utilidades = Utilidades()

        return  utilidades.validateEmail(email_text, email) and
                utilidades.validateEmail(email_confirmation_text, email_confirmation) and
                utilidades.validateNull(username_text, username) and
                utilidades.validateNull(password_text, password) and
                utilidades.validateNull(password_confirmation_text, password_confirmation) and
                (email_confirmation_text != email_text)
    }
}