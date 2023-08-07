package com.example.dynamic_appointment_application.models

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("username") val username: String? = null,
    @SerializedName("password") val password: String? = null
)