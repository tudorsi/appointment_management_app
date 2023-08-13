package com.example.dynamic_appointment_application.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderServiceItemBinding
import com.example.dynamic_appointment_application.models.ServiceModel

class ServicesRecyclerViewAdapter(private var items: List<ServiceModel>) :
    RecyclerView.Adapter<ServicesRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesRecyclerViewHolder {
        return ServicesRecyclerViewHolder(
            ViewHolderServiceItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ServicesRecyclerViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    fun updateData(items: List<ServiceModel>) {
        this.items = items
        notifyDataSetChanged()
    }
}