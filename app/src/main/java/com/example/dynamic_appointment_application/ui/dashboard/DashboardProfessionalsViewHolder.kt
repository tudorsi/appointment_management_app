package com.example.dynamic_appointment_application.ui.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderDashboardProfessionalBinding
import com.example.dynamic_appointment_application.models.Professional

class DashboardProfessionalsViewHolder(private val binding: ViewHolderDashboardProfessionalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(item: Professional) {
        binding.nameTextView.text = item.name
        binding.ratingTextView.text = item.rating.toString()
    }
}

