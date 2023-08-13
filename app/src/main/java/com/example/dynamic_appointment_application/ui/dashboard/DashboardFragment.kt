package com.example.dynamic_appointment_application.ui.dashboard

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentDashboardBinding
import com.example.dynamic_appointment_application.models.ServiceModel

class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    override fun FragmentDashboardBinding.onViewCreated(savedInstanceState: Bundle?) {
        val servicesRecyclerViewAdapter = ServicesRecyclerViewAdapter(
            listOf(
                ServiceModel("Haircut"),
                ServiceModel("Beard"),
                ServiceModel("Makeup")
            )
        )
        servicesRecyclerView.layoutManager = LinearLayoutManager(context)
        servicesRecyclerView.adapter = servicesRecyclerViewAdapter

    }
}