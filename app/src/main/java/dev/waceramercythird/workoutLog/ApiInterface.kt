package dev.waceramercythird.workoutLog

import dev.waceramercythird.workoutLog.models.RegisterRequest
import dev.waceramercythird.workoutLog.models.RegisterResponse
import dev.waceramercythird.workoutLog.repository.UserRepository
import dev.waceramercythird.workoutLog.ui.LogInRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: LogInRequest): Call<RegisterResponse>

    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LogInRequest): Response<LogInRequest>

    @POST("/signin")
    suspend fun signinUser(@Body signinRequest: UserRepository.SignInRequest): Response<UserRepository.SignInRequest>

}


