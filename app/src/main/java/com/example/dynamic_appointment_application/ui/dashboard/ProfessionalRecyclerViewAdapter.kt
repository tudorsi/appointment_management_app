package com.example.dynamic_appointment_application.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderProfessionalItemBinding
import com.example.dynamic_appointment_application.models.Professional

class ProfessionalRecyclerViewAdapter(private val items: List<Professional>) :
    RecyclerView.Adapter<ProfessionalsRecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfessionalsRecyclerViewHolder {
        return ProfessionalsRecyclerViewHolder(
            ViewHolderProfessionalItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfessionalsRecyclerViewHolder, position: Int) {
        val item = items[position]
        holder.bindData(item)
    }

    override fun getItemCount(): Int = items.size
}