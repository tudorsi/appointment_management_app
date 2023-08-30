package com.example.dynamic_appointment_application.models

import com.google.gson.annotations.SerializedName

data class BusinessModel(
    @SerializedName("businessId") val businessId: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("county") val county: String? = null,
    @SerializedName("address") val address: String? = null,
    @SerializedName("latitude") val latitude: Double? = null,
    @SerializedName("longitude") val longitude: Double? = null
)
