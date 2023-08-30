package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.ApiService
import com.example.dynamic_appointment_application.Network.RemoteServicesHandler
import com.example.dynamic_appointment_application.Network.Resource
import com.example.dynamic_appointment_application.models.Professional

class ProfessionalsRepository(
    private val apiService: ApiService,
    private val servicesHandler: RemoteServicesHandler
) {
    suspend fun getBusinessProfessionalsByServiceId(
        businessId: String,
        serviceId: String
    ): Resource<List<Professional>> = servicesHandler.makeTheCallAndHandleResponse(
        serviceCall = { apiService.getBusinessProfessionalsByServiceId(businessId, serviceId) },
        mapSuccess = { Resource.Success(it.body(), it.code()) }
    )

}