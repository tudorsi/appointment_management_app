package com.example.dynamic_appointment_application.models

import com.google.gson.annotations.SerializedName

data class RegisterRequestBody(
    @SerializedName("email") val email:String? = null,
    @SerializedName("firstName") val firstName: String? = null,
    @SerializedName("lastName") val lastName: String? = null,
    @SerializedName("password") val password: String? = null
)