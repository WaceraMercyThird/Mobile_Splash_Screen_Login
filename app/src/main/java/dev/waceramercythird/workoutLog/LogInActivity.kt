package dev.waceramercythird.workoutLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {
    lateinit var tvSignUp: TextView
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        tvSignUp = findViewById(R.id.tvSignup)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword2)
        btnLogin = findViewById(R.id.btnLogin)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword2)

        tvSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

            validateLogin()

        }
    }
        fun validateLogin(){
            var email = etEmail.text.toString()
            var password =etPassword.text.toString()
            if (email.isBlank()){
                tilEmail.error = "Email is required"
            }

            if (password.isBlank()){
                tilPassword.error = "Password is required"
            }
        }
    }
