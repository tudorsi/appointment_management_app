package com.example.dynamic_appointment_application.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderDashboardProfessionalBinding
import com.example.dynamic_appointment_application.models.Professional

class DashboardProfessionalsRecyclerViewAdapter(private val items: List<Professional>) :
    RecyclerView.Adapter<DashboardProfessionalsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DashboardProfessionalsViewHolder {
        return DashboardProfessionalsViewHolder(
            ViewHolderDashboardProfessionalBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DashboardProfessionalsViewHolder, position: Int) {

        holder.bindData(items[position])
    }

    override fun getItemCount(): Int = items.size
}