package com.example.dynamic_appointment_application.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamic_appointment_application.LoginUseCase
import com.example.dynamic_appointment_application.Network.Status
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val loginStatusLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun login(username: String?, password: String?) {
        viewModelScope.launch {
            loginUseCase.login(username, password).collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        loginStatusLiveData.value = "User logged in"
                    }

                    Status.ERROR -> {
                        Log.d("loginError", it.message.toString())
                    }

                    Status.LOADING -> {}
                }
            }
        }
    }

}