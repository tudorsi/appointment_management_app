package com.example.dynamic_appointment_application.Network

import com.example.dynamic_appointment_application.models.BusinessModel
import com.example.dynamic_appointment_application.models.LoginRequestBody
import com.example.dynamic_appointment_application.models.LoginResponse
import com.example.dynamic_appointment_application.models.Professional
import com.example.dynamic_appointment_application.models.RegisterRequestBody
import com.example.dynamic_appointment_application.models.ServiceModel
import com.example.dynamic_appointment_application.models.SuccessResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("/api/account/register")
    fun registerNewUser(@Body registerRequestBody: RegisterRequestBody): Call<SuccessResponse>

    @POST("/api/account/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody): Response<LoginResponse>

    @GET("/api/service/getServices")
    suspend fun getServices(): Response<List<ServiceModel>>

    @GET("api/business/getBusinessesByServiceId/{serviceId}")
    suspend fun getBusinessesByServiceId(
        @Path("serviceId") serviceId: String
    ): Response<List<BusinessModel>>

    @GET("/api/professional/getBusinessProfessionalsByServiceId/{businessId}")
    suspend fun getBusinessProfessionalsByServiceId(
        @Path("businessId") businessId: String,
        @Query("serviceId") serviceId: String
    ): Response<List<Professional>>
}