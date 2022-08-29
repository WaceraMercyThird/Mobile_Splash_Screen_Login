package dev.waceramercythird.workoutLog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.databinding.ActivitySignupBinding
import dev.waceramercythird.workoutLog.models.RegisterRequest

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleclick()
    }
    fun handleclick(){
        binding.tvLogin2.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

        }

        binding.btnSignup2.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            validateRegitration()

        }
    }
    fun validateRegitration(){
        var firstname = binding.etFirstname.text.toString()
        var secondname = binding.etSecondname.text.toString()
        var phonenumber = binding.etPhonenumber.text.toString()
        var email = binding.etEmail2.text.toString()
        var password = binding.etPassword2.text.toString()
        var Confpassword =binding.etConfpassword.text.toString()

        var error = false

        if (firstname.isBlank()){
            error = true
            binding.tilFirstname.error = "First name is required"
        }

        if (secondname.isBlank()){
            error = true
            binding.tilSecondname.error = "Second name is required."
        }
        if (phonenumber.isBlank()){
            error = true
            binding.tilSecondname.error = "Phone number is required."
        }

        if (email.isBlank()){
            error = true
            binding.tilEmail2.error = "Email is required"
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            error = true
            binding.tilEmail2.error = "Email is invalid"
        }

        if (password.isBlank()){
            error = true
            binding.tilPassword2.error = "Password is required"
        }
        if (Confpassword.isBlank()){
            error = true
            binding.tilConfpassword.error = "Confirmation is required"
        }
        if (Confpassword!=password){
            error = true
            binding.tilConfpassword.error = "invalid password"
        }
        if (!error){
            var registerRequest = RegisterRequest(firstname,secondname,phonenumber,email, password)
        }
    }
    fun makeRegistrationRequest(registerRequest: RegisterRequest){
        var apiClient = ApiClient.buildApiClient(ApiClient::class.java)
        var request = apiClient.registerUser(registerRequest)

        request.enqeue(Object : Callback<RegisterResponse>{
//            onResponse
//            if (response.isSuccessful){
//                var message = response.body()?.message
//                Toast.makeText(baseContext, massage, Toast.LENGTH_LONG).show()
//                startActivity(Intent(baseContext.LoginActivity::class.java))
//            }
//            else {
//                var error =response.Sstring()
//                Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//
//
////                onfailure
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//            }


        }

//        })
//    }
}