package com.example.dynamic_appointment_application.extensions

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: RecyclerView.NO_POSITION
    val snapView = findSnapView(
        layoutManager as RecyclerView.LayoutManager
    ) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}