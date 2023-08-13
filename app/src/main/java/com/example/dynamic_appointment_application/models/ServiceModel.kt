package com.example.dynamic_appointment_application.models

import com.google.gson.annotations.SerializedName

data class ServiceModel(
    @SerializedName("name") val name: String? = null,
    @SerializedName("cost") val cost: Double? = null
)