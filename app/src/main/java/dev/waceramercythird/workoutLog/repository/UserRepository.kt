package dev.waceramercythird.workoutLog.repository

import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.ApiInterface
import dev.waceramercythird.workoutLog.ui.LogInRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(logInRequest: LogInRequest):
            Response<LogInRequest> =
        withContext(Dispatchers.IO) {
            var response = apiClient.loginUser(logInRequest)
            return@withContext response
        }
    suspend fun signinUser(signInRequest: SignInRequest):
            Response<SignInRequest> =
        withContext(Dispatchers.IO) {
            var response = apiClient.signinUser(signInRequest)
            return@withContext response
        }

    class SignInRequest {

    }
}
