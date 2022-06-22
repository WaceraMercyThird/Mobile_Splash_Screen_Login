package dev.waceramercythird.workoutLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.waceramercythird.workoutLog.databinding.ActivityLogInBinding
import dev.waceramercythird.workoutLog.databinding.ActivitySignupBinding

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

            validateLogin()

        }
    }
    fun validateLogin(){
        var firstname = binding.etFirstname.text.toString()
        var secondname = binding.etSecondname.text.toString()
        var email = binding.etEmail2.text.toString()
        var password = binding.etPassword2.text.toString()
        var Confpassword =binding.etConfpassword.text.toString()

        if (firstname.isBlank()){
            binding.tilFirstname.error = "First name is required"
        }

        if (secondname.isBlank()){
            binding.tilSecondname.error = "Second name is required."
        }

        if (email.isBlank()){
            binding.tilEmail2.error = "Email is required"
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmail2.error = "Email is invalid"
        }

        if (password.isBlank()){
            binding.tilPassword2.error = "Password is required"
        }
        if (Confpassword.isBlank()){
            binding.tilConfpassword.error = "Confirmation is required"
        }
        if (Confpassword!=password){
            binding.tilConfpassword.error = "invalid password"
        }
    }
}