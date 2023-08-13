package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.Resource
import kotlinx.coroutines.flow.flow

class GetServicesUseCase(
    private val appointmentServiceRepository: AppointmentServiceRepository
) {
    suspend fun getServices() = flow {
        emit(Resource.Loading())
        val response = appointmentServiceRepository.getServices()
        emit(response)
    }
}