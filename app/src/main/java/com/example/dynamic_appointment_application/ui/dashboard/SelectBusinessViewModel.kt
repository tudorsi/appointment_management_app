package com.example.dynamic_appointment_application.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamic_appointment_application.GetBusinessesUseCase
import com.example.dynamic_appointment_application.Network.Status
import com.example.dynamic_appointment_application.models.BusinessModel
import kotlinx.coroutines.launch

class SelectBusinessViewModel(
    private val getBusinessesUseCase: GetBusinessesUseCase
) : ViewModel() {

    val businessListLiveData: MutableLiveData<List<BusinessModel>> by lazy {
        MutableLiveData<List<BusinessModel>>()
    }

    fun getBusinessesByServiceId(serviceId: String) {
        viewModelScope.launch {
            getBusinessesUseCase.getBusinessByServiceId(serviceId).collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        businessListLiveData.value = it.data
                    }

                    Status.LOADING -> {}
                    Status.ERROR -> {}
                }
            }
        }

    }
}