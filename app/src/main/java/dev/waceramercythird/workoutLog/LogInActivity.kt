package dev.waceramercythird.workoutLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.waceramercythird.workoutLog.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)


      handleClick()
    }
    fun handleClick(){
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

            validateLogin()

        }
    }

    fun validateLogin(){
        var email = binding.etEmail.text.toString()
        var password =binding.etPassword2.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error = "Email is required"
        }

        if (password.isBlank()){
            binding.tilPassword2.error = "Password is required"
        }
    }


    }
