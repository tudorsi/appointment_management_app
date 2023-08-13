package com.example.dynamic_appointment_application.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamic_appointment_application.GetServicesUseCase
import com.example.dynamic_appointment_application.Network.Status
import com.example.dynamic_appointment_application.models.ServiceModel
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val getServicesUseCase: GetServicesUseCase
) : ViewModel() {
    val servicesListLiveData: MutableLiveData<List<ServiceModel>> by lazy {
        MutableLiveData<List<ServiceModel>>()
    }

    fun getServices() {
        viewModelScope.launch {
            getServicesUseCase.getServices().collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        servicesListLiveData.value = it.data
                    }

                    Status.LOADING -> {}
                    Status.ERROR -> {}
                }
            }
        }
    }
}