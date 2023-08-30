package com.example.dynamic_appointment_application.ui.dashboard

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.R
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentDashboardBinding
import com.example.dynamic_appointment_application.models.Professional
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val servicesRecyclerViewAdapter = ServicesRecyclerViewAdapter(listOf()) {
        val bundle = bundleOf("selectedServiceId" to it.serviceId)
        navigate(R.id.action_fragment_dashboard_to_fragment_select_business, bundle)
    }
    private val professionalsRecyclerViewAdapter = DashboardProfessionalsRecyclerViewAdapter(
        listOf(
            Professional("Popescu Andrei", 5.0, "UTCN software"),
            Professional("Sipos Tudor", 4.9, "Test business 1"),
            Professional("Sipos Ciprian", 4.9, "Test business1")
        )
    )

    override fun FragmentDashboardBinding.onViewCreated(savedInstanceState: Bundle?) {
        dashboardViewModel.getServices()
        dashboardViewModel.servicesListLiveData.observe(viewLifecycleOwner) {
            servicesRecyclerViewAdapter.updateData(it)
        }
        servicesRecyclerView.layoutManager = LinearLayoutManager(context)
        servicesRecyclerView.adapter = servicesRecyclerViewAdapter
        professionalsRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        professionalsRecyclerView.adapter = professionalsRecyclerViewAdapter

    }
}