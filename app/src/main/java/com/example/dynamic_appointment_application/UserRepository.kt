package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.ApiService
import com.example.dynamic_appointment_application.Network.RemoteServicesHandler
import com.example.dynamic_appointment_application.Network.Resource
import com.example.dynamic_appointment_application.models.LoginRequestBody
import com.example.dynamic_appointment_application.models.LoginResponse

class UserRepository(
    private val apiService: ApiService,
    private val servicesHandler: RemoteServicesHandler
) {
    suspend fun login(loginRequestBody: LoginRequestBody): Resource<LoginResponse> =
        servicesHandler.makeTheCallAndHandleResponse(
            serviceCall = { apiService.login(loginRequestBody) },
            mapSuccess = { Resource.Success(it.body(), it.code()) }
        )

}