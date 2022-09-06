package dev.waceramercythird.workoutLog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.ApiInterface
import dev.waceramercythird.workoutLog.databinding.ActivityLogInBinding
import dev.waceramercythird.workoutLog.models.RegisterRequest2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("WORKOUTlOG_PREFS", MODE_PRIVATE)


        handleClick()
    }

    fun handleClick() {
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

    fun validateLogin() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword2.text.toString()
        var error = false

        if (email.isBlank()) {
            error = true
            binding.tilEmail.error = "Email is required"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            error = true
            binding.tilEmail.error = "Email is invalid"
        }

        if (password.isBlank()) {
            error = true
            binding.tilPassword2.error = "Password is required"
        }
        if (!error) {
            var loginRequest = RegisterRequest2(email, password)
            userViewModel.login(LogInRequest)

        }
//
    }

    fun makeRegisterationRequest(loginRequest: LogInRequest) {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.registerUser(loginRequest)

        request.enqueue(object : Callback<LogInResponse> {
            override fun onResponse(
                call: Call<LogInResponse>,
                response: Response<LogInResponse>
            ) {
                if (response.isSuccessful) {
                    var loginResponse = response.body()
                    Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
                    //Open Home

                } else {
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()

                }
            }


            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
    fun persistLoginDetails(logInResponse: LogInResponse){
        var editor = sharedPrefs.edit()
        editor.putString("USER_ID", logInResponse.userId)
        editor.putString("ACCESS_TOKEN", logInResponse.accessToken)
        editor.putString("PROFILE_ID", logInResponse.profileId)
        editor.apply()


    }
}
