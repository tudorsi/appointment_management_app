package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.ApiService
import com.example.dynamic_appointment_application.Network.RemoteServicesHandler
import com.example.dynamic_appointment_application.Network.Resource
import com.example.dynamic_appointment_application.models.ServiceModel

class AppointmentServiceRepository(
    private val apiService: ApiService,
    private val servicesHandler: RemoteServicesHandler
) {
    suspend fun getServices(): Resource<List<ServiceModel>> =
        servicesHandler.makeTheCallAndHandleResponse(
            serviceCall = { apiService.getServices() },
            mapSuccess = { Resource.Success(it.body(), it.code()) }
        )

}