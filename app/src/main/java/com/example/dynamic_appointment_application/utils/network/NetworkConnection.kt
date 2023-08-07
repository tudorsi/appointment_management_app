package com.example.dynamic_appointment_application.utils.network

import android.util.Log

object NetworkConnection : NetworkConnectivityListener {
    private val TAG = NetworkConnection::class.simpleName

    var isConnected: Boolean = false
        private set

    override fun onConnected() {
        updateConnectionState(true)
        Log.d("connectionStatus", "true")
    }

    override fun onDisconnected() {
        updateConnectionState(false)
    }

    private fun updateConnectionState(isConnected: Boolean) {
        Log.d(TAG, "isNetworkConnected: $isConnected")
        NetworkConnection.isConnected = isConnected
    }
}