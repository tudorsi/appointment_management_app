package com.example.dynamic_appointment_application.ui.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderProfessionalItemBinding
import com.example.dynamic_appointment_application.models.Professional

class ProfessionalsRecyclerViewHolder(private val binding: ViewHolderProfessionalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(item: Professional) {
        binding.nameTextView.text = item.name
    }
}