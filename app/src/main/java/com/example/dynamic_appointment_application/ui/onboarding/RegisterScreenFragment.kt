package com.example.dynamic_appointment_application.ui.onboarding

import android.os.Bundle
import com.example.dynamic_appointment_application.R
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentRegisterScreenBinding

class RegisterScreenFragment :
    BaseFragment<FragmentRegisterScreenBinding>(FragmentRegisterScreenBinding::inflate) {
    override fun FragmentRegisterScreenBinding.onViewCreated(savedInstanceState: Bundle?) {
        setStatusBarColor(R.color.primary_purple, false)

        goToLoginTextView.setOnClickListener {
            navigate(R.id.action_fragment_register_to_fragment_login)
        }

        /*val service: ApiService =
            RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)

        registerButon.setOnClickListener {
            service.registerNewUser(
                RegisterRequestBody(
                    emailEditText.text.toString(),
                    firstNameEditText.text.toString(),
                    lastNameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            ).enqueue(object : Callback<SuccessResponse> {
                override fun onResponse(
                    call: Call<SuccessResponse>,
                    response: Response<SuccessResponse>
                ) {
                    showToast("user created successfully")
                }

                override fun onFailure(call: Call<SuccessResponse>, t: Throwable) {
                    Log.d("callError", t.message.toString())
                }
            })

        }*/
    }

}