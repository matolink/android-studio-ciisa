package com.example.todociisa

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.todociisa.utils.Utilidades
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class Nueva_Cuenta : AppCompatActivity() {

    private var username: TextInputLayout? = null
    private var email: TextInputLayout? = null
    private var email_confirmation: TextInputLayout? = null
    private var password: TextInputLayout? = null
    private var password_confirmation: TextInputLayout? = null
    private var birthday_container: TextInputLayout? = null
    private var birthday: EditText? = null

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
        birthday_container = findViewById<TextInputLayout>(R.id.birthdayPickerContainer)
        birthday = findViewById<EditText>(R.id.birthdayPicker)
    }

    fun setClickListenners(){
        val button = findViewById<Button>(R.id.nueva_cuenta_crear)
        button.setOnClickListener{
            this.onCreateButtonClick()
        }
        val cancelButton = findViewById<Button>(R.id.nueva_cuenta_cancelar)
        cancelButton.setOnClickListener{
            finish()
        }
        val birthdayHandler = findViewById<EditText>(R.id.birthdayPicker)
        birthdayHandler.setOnClickListener{
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                birthday?.setText(dat)
            },
            year,
            month,
            day
        )
        datePickerDialog.getDatePicker().setMaxDate(Date().getTime())
        datePickerDialog.show()
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
        val birthday_text = birthday?.text.toString()
        Log.d("TEST", birthday_text)
        val utilidades = Utilidades()

        return  utilidades.validateEmail(email_text, email) and
                utilidades.validateEmail(email_confirmation_text, email_confirmation) and
                utilidades.validateNull(username_text, username) and
                utilidades.validateNull(password_text, password) and
                utilidades.validateNull(password_confirmation_text, password_confirmation) and
                utilidades.validateDate(birthday_text, birthday_container) and
                (email_confirmation_text != email_text)
    }
}