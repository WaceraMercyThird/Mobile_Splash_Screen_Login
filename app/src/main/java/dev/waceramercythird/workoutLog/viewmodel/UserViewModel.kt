package dev.waceramercythird.workoutLog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.waceramercythird.workoutLog.models.RegisterRequest2
import dev.waceramercythird.workoutLog.models.RegisterResponse
import dev.waceramercythird.workoutLog.repository.UserRepository
import dev.waceramercythird.workoutLog.ui.LogInRequest
import dev.waceramercythird.workoutLog.ui.LogInResponse

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    val loginLiveData = MutableLiveData<LogInResponse>()
    val loginError = MutableLiveData<String>()
    var registerLiveData = MutableLiveData<registerResponse>()
    var registerError = MutableLiveData<String>()
    val signinLiveData = MutableLiveData<SignInResponse>()
    val signinError = MutableLiveData<String>()


    fun login(logInRequest: LogInRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(logInRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }
    }
    fun register(registerRequest2: RegisterRequest2) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest2)
            if (response.isSuccessful){
                registerLiveData.postValue(response.body())
            }
            else{
                registerError.postValue(response.errorBody()?.string())
            }

        }
    }
    fun signin(signInRequest: UserRepository.SignInRequest) {
        viewModelScope.launch {
            val response = userRepository.signinUser(signInRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }

//    concurrency and Parallesism??


}