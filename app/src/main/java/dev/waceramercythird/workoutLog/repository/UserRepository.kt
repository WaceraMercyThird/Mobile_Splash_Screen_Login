package dev.waceramercythird.workoutLog.repository

import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.ApiInterface
import dev.waceramercythird.workoutLog.ui.LogInRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

//class UserRepository {
//    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
//
//    suspend fun loginuser(logInRequest: LogInRequest) Response<LoginResponse>
//    = withContext(Dispatcher.IO) {
//        val response = apiClient.loginUser(loginResponse)
//        return@withContext response
//    }
//}

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(logInRequest: LogInRequest):
            Response<LogInRequest> =
        withContext(Dispatchers.IO) {
            var response = apiClient.registerStudent(logInRequest)
            return@withContext response
        }
}