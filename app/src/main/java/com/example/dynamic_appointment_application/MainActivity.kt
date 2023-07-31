package com.example.dynamic_appointment_application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamic_appointment_application.Network.ApiService
import com.example.dynamic_appointment_application.Network.RetrofitClientInstance.getRetrofitInstance
import com.example.dynamic_appointment_application.models.RegisterRequestBody
import com.example.dynamic_appointment_application.models.SuccessResponse
import retrofit2.Call


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}