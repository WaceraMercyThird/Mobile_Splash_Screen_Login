package dev.waceramercythird.workoutLog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name") var firstName: String,
    @SerializedName("second_name") var lastName : String,
    @SerializedName("phone_name") var phoneNumber: String,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
)
data class RegisterRequest2(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
)
