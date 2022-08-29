package dev.waceramercythird.workoutLog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.databinding.ActivityLogInBinding
import dev.waceramercythird.workoutLog.models.RegisterRequest
import dev.waceramercythird.workoutLog.models.RegisterRequest2

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

        var error = false

        if (email.isBlank()){
            error = true
            binding.tilEmail.error = "Email is required"
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            error = true
            binding.tilEmail.error = "Email is invalid"
        }

        if (password.isBlank()){
            error = true
            binding.tilPassword2.error= "Password is required"
        }
        if (!error){
            var registerRequest = RegisterRequest2(email, password)
        }
    }
    fun makeRegistrationRequest(registerRequest: RegisterRequest){
        var apiClient = ApiClient.buildApiClient(ApiClient::class.java)
        var request = apiClient.registerUser(registerRequest)


    }}
