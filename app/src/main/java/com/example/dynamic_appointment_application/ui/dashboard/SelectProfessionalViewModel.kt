package com.example.dynamic_appointment_application.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamic_appointment_application.GetProfessionalsUseCase
import com.example.dynamic_appointment_application.Network.Status
import com.example.dynamic_appointment_application.models.Professional
import kotlinx.coroutines.launch

class SelectProfessionalViewModel(
    private val getProfessionalsUseCase: GetProfessionalsUseCase
) : ViewModel() {
    val professionalsLiveData: MutableLiveData<List<Professional>> by lazy {
        MutableLiveData<List<Professional>>()
    }

    fun getBusinessProfessionalsByServiceId(businessId: String, serviceId: String) {
        viewModelScope.launch {
            getProfessionalsUseCase.getBusinessProfessionalsByServiceId(businessId, serviceId)
                .collect {
                    when (it.status) {
                        Status.SUCCESS -> {
                            professionalsLiveData.value = it.data
                        }

                        Status.LOADING -> {}
                        Status.ERROR -> {}
                    }
                }
        }
    }
}