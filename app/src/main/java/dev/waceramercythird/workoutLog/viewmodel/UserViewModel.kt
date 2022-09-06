package dev.waceramercythird.workoutLog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.waceramercythird.workoutLog.repository.UserRepository
import dev.waceramercythird.workoutLog.ui.LogInRequest
import dev.waceramercythird.workoutLog.ui.LogInResponse

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    val loginLiveData = MutableLiveData<LogInResponse>()
    val loginError = MutableLiveData<String>()


    fun login(logInRequest: LogInRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(logInRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.String())
            }
        }
    }


}