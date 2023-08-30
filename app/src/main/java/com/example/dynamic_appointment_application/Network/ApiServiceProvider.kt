package com.example.dynamic_appointment_application.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://192.168.1.144:8090/"

class ApiServiceProvider(private val okHttpClient: OkHttpClient) {

    fun createApiService(): ApiService {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = retrofitBuilder.client(okHttpClient).build()
        return retrofit.create(ApiService::class.java)
    }

}
