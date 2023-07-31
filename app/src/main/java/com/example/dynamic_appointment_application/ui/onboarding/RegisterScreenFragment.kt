package com.example.dynamic_appointment_application.ui.onboarding

import BaseFragment
import android.os.Bundle
import android.util.Log
import com.example.dynamic_appointment_application.Network.ApiService
import com.example.dynamic_appointment_application.Network.RetrofitClientInstance
import com.example.dynamic_appointment_application.R
import com.example.dynamic_appointment_application.databinding.FragmentRegisterScreenBinding
import com.example.dynamic_appointment_application.models.RegisterRequestBody
import com.example.dynamic_appointment_application.models.SuccessResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.scope.fragmentScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterScreenFragment : BaseFragment<FragmentRegisterScreenBinding>(FragmentRegisterScreenBinding::inflate) {
    override fun FragmentRegisterScreenBinding.onViewCreated(savedInstanceState: Bundle?) {
        setStatusBarColor(R.color.primary_purple, false)

        val service: ApiService = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)


        registerButon.setOnClickListener {
            service.registerNewUser(
                RegisterRequestBody(
                    emailEditText.text.toString(),
                    firstNameEditText.text.toString(),
                    lastNameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            ).enqueue(object : Callback<SuccessResponse> {
                override fun onResponse(call: Call<SuccessResponse>, response: Response<SuccessResponse>) {
                    showToast("user created successfully")
                }

                override fun onFailure(call: Call<SuccessResponse>, t: Throwable) {
                    Log.d("callError", t.message.toString())
                }
            })

        }
    }

}