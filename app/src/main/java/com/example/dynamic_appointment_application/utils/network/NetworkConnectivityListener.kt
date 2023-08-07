package com.example.dynamic_appointment_application.utils.network

interface NetworkConnectivityListener {
    fun onConnected()

    fun onDisconnected()
}