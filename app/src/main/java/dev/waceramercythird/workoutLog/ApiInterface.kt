package dev.waceramercythird.workoutLog

import dev.waceramercythird.workoutLog.models.RegisterRequest
import dev.waceramercythird.workoutLog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/register")
    fun registerUser (@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}