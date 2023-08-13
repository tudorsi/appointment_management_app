package com.example.dynamic_appointment_application.ui.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderServiceItemBinding
import com.example.dynamic_appointment_application.models.ServiceModel

class ServicesRecyclerViewHolder(private val binding: ViewHolderServiceItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: ServiceModel) {
        binding.nameTextView.text = item.name
    }

}