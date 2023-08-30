package com.example.dynamic_appointment_application.ui.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderBusinessCardBinding
import com.example.dynamic_appointment_application.models.BusinessModel

class BusinessRecyclerViewHolder(private val binding: ViewHolderBusinessCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val selectButton = binding.selectButton
    fun bindData(item: BusinessModel) {
        binding.businessNameTextView.text = item.name
        binding.businessAddressTextView.text = "${item.county}, ${item.city}, ${item.address}"
    }

}