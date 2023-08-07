package com.example.dynamic_appointment_application.Network

import com.example.dynamic_appointment_application.utils.network.NetworkConnection
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkNotAvailableInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (NetworkConnection.isConnected) {
            chain.proceed(chain.request())
        } else {
            throw IOException()
        }
    }
}