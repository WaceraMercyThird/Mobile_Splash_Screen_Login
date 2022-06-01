package dev.waceramercythird.workoutLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tvLogin2: TextView
    lateinit var etFirstname: TextInputEditText
    lateinit var etSecondname: TextInputEditText
    lateinit var etEmail2: TextInputEditText
    lateinit var etPassword2: TextInputEditText
    lateinit var etConfPassword: TextInputEditText
    lateinit var tilFirstname: TextInputLayout
    lateinit var tilSecondname: TextInputLayout
    lateinit var tilEmail2: TextInputLayout
    lateinit var tilPassword2: TextInputLayout
    lateinit var tilConfpassword: TextInputLayout
    lateinit var btnSignup2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        tvLogin2 = findViewById(R.id.tvLogin2)
        etFirstname = findViewById(R.id.etFirstname)
        etSecondname = findViewById(R.id.etSecondname)
        etEmail2 = findViewById(R.id.etEmail2)
        etPassword2 = findViewById(R.id.etPassword2)
        etConfPassword = findViewById(R.id.etConfpassword)
        btnSignup2 = findViewById(R.id.btnSignup2)
        tilEmail2 = findViewById(R.id.tilEmail2)
        tilPassword2 = findViewById(R.id.tilPassword2)
        tilFirstname = findViewById(R.id.tilFirstname)
        tilSecondname = findViewById(R.id.tilSecondname)
        tilConfpassword = findViewById(R.id.tilConfpassword)



        tvLogin2.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

        }

        btnSignup2.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

            validateLogin()

        }
    }
    fun validateLogin(){
        var firstname = etFirstname.text.toString()
        var secondname =etSecondname.text.toString()
        var email = etEmail2.text.toString()
        var password =etPassword2.text.toString()
        var Confpassword =etConfPassword.text.toString()

        if (firstname.isBlank()){
            tilFirstname.error = "First name is required"
        }

        if (secondname.isBlank()){
            tilSecondname.error = "Second name is required"
        }

        if (email.isBlank()){
            tilEmail2.error = "Email is required"
        }

        if (password.isBlank()){
            tilPassword2.error = "Password is required"
        }
        if (Confpassword.isBlank()){
            tilConfpassword.error = "Confirmation Password is required"
        }
    }
}