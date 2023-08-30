package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.Resource
import kotlinx.coroutines.flow.flow

class GetBusinessesUseCase(
    private val businessRepository: BusinessRepository
) {
    suspend fun getBusinessByServiceId(serviceId: String) = flow {
        emit(Resource.Loading())
        val response = businessRepository.getBusinessesByServiceId(serviceId)
        emit(response)
    }
}