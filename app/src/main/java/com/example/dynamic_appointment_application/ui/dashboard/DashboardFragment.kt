package com.example.dynamic_appointment_application.ui.dashboard

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val servicesRecyclerViewAdapter = ServicesRecyclerViewAdapter(listOf())
    override fun FragmentDashboardBinding.onViewCreated(savedInstanceState: Bundle?) {
        dashboardViewModel.getServices()
        dashboardViewModel.servicesListLiveData.observe(viewLifecycleOwner) {
            servicesRecyclerViewAdapter.updateData(it)
        }
        servicesRecyclerView.layoutManager = LinearLayoutManager(context)
        servicesRecyclerView.adapter = servicesRecyclerViewAdapter

    }
}