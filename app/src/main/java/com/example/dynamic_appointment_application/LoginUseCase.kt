package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.Resource
import com.example.dynamic_appointment_application.models.LoginRequestBody
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val userRepository: UserRepository) {
    suspend fun login(username: String?, password: String?) = flow {
        emit(Resource.Loading())
        val response = userRepository.login(LoginRequestBody(username, password))
        emit(response)

    }

}