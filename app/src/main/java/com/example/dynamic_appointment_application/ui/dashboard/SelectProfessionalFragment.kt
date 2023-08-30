package com.example.dynamic_appointment_application.ui.dashboard

import android.os.Bundle
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentSelectProfessionalBinding
import com.example.dynamic_appointment_application.models.Professional
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectProfessionalFragment :
    BaseFragment<FragmentSelectProfessionalBinding>(FragmentSelectProfessionalBinding::inflate) {
    private val selectProfessionalViewModel: SelectProfessionalViewModel by viewModel()
    private val professionalsRecyclerViewAdapter = ProfessionalRecyclerViewAdapter(
        listOf(
            Professional("dudi", 5.0),
            Professional("ducu", 4.3)
        )
    )

    override fun FragmentSelectProfessionalBinding.onViewCreated(savedInstanceState: Bundle?) {
        /*TODO:
        *  call lista de profesionisti
        * afiseaza lista profesionisti
        * screen summary appointment
        * navigation bottom bar
        * afisare lista de programari*/
//        professionalsRecyclerView.adapter = professionalsRecyclerViewAdapter
//        professionalsRecyclerView.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }
}