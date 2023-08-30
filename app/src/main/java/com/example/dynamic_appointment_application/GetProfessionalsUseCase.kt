package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.Resource
import kotlinx.coroutines.flow.flow

class GetProfessionalsUseCase(
    private val professionalsRepository: ProfessionalsRepository,
) {

    suspend fun getBusinessProfessionalsByServiceId(businessId: String, serviceId: String) = flow {
        emit(Resource.Loading())
        val response =
            professionalsRepository.getBusinessProfessionalsByServiceId(businessId, serviceId)
        emit(response)
    }
}