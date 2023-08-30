package com.example.dynamic_appointment_application.models

import com.google.gson.annotations.SerializedName

data class Professional(
    @SerializedName("name") val name: String? = null,
    @SerializedName("rating") val rating: Double? = null,
    val business: String? = null
)
