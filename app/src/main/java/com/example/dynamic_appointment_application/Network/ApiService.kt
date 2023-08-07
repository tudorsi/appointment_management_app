package com.example.dynamic_appointment_application.Network

import com.example.dynamic_appointment_application.models.LoginRequestBody
import com.example.dynamic_appointment_application.models.LoginResponse
import com.example.dynamic_appointment_application.models.RegisterRequestBody
import com.example.dynamic_appointment_application.models.SuccessResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/account/register")
    fun registerNewUser(@Body registerRequestBody: RegisterRequestBody): Call<SuccessResponse>

    @POST("/api/account/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody): Response<LoginResponse>
}