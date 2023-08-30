package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.ApiService
import com.example.dynamic_appointment_application.Network.RemoteServicesHandler
import com.example.dynamic_appointment_application.Network.Resource
import com.example.dynamic_appointment_application.models.BusinessModel

class BusinessRepository(
    private val apiService: ApiService,
    private val servicesHandler: RemoteServicesHandler
) {
    suspend fun getBusinessesByServiceId(serviceId: String): Resource<List<BusinessModel>> =
        servicesHandler.makeTheCallAndHandleResponse(
            serviceCall = { apiService.getBusinessesByServiceId(serviceId) },
            mapSuccess = { Resource.Success(it.body(), it.code()) }
        )
}