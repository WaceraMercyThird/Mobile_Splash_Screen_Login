package dev.waceramercythird.workoutLog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.ApiInterface
import dev.waceramercythird.workoutLog.databinding.ActivitySignupBinding
import dev.waceramercythird.workoutLog.models.RegisterRequest
import dev.waceramercythird.workoutLog.models.RegisterResponse
import dev.waceramercythird.workoutLog.repository.UserRepository
import dev.waceramercythird.workoutLog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var sharedPrefs: SharedPreferences


    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("WORKOUTlOG_PREFS", MODE_PRIVATE)


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
    override fun onResume() {
        super.onResume()
        userViewModel.signinLiveData.observe(this, Observer {
                signinResponse->
            Toast.makeText(baseContext, signinResponse?.message, Toast.LENGTH_LONG).show()
            persistLoginDetails(signinResponse!!)
            startActivity(Intent(baseContext, HomeActivity::class.java))
        })

        userViewModel.loginError.observe(this, Observer { errorMsg->
            Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()

        })
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
            binding.progressBarRegister.visibility = View.VISIBLE
            userViewModel.signin(UserRepository.SignInRequest)

        }

//            var registerRequest = RegisterRequest(firstname,secondname,phonenumber,email, password)
//        makeRegisterationRequest(registerRequest)
    }


    }
fun makeRegisterationRequest(registerRequest: RegisterRequest){
    var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    var request=apiClient.registerUser(registerRequest)

    request.enqueue(object :retrofit2.Callback<RegisterResponse>{
        override fun onResponse(
            call: Call<RegisterResponse>,
            response: Response<RegisterResponse>
        ) {
            if (response.isSuccessful){
                var message=response.body()?.message
                Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()

            }else{
                val error=response.errorBody()?.string()
                Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()

            }
        }

        override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()        }
    })


    }





