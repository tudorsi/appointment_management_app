package com.example.dynamic_appointment_application.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.databinding.ViewHolderBusinessCardBinding
import com.example.dynamic_appointment_application.models.BusinessModel

class BusinessesRecyclerViewAdapter(
    private var items: List<BusinessModel>,
    private val listener: (businessId: String) -> Unit
) : RecyclerView.Adapter<BusinessRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessRecyclerViewHolder {
        return BusinessRecyclerViewHolder(
            ViewHolderBusinessCardBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BusinessRecyclerViewHolder, position: Int) {
        val item = items[position]
        holder.bindData(item)
        holder.selectButton.setOnClickListener {
            item.businessId?.let { id -> listener.invoke(id) }
        }
    }

    fun getItems(): List<BusinessModel> {
        return items
    }

    fun setItems(items: List<BusinessModel>) {
        this.items = items
        notifyDataSetChanged()
    }
}