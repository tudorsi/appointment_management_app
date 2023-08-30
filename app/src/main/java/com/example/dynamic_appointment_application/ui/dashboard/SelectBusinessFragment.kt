package com.example.dynamic_appointment_application.ui.dashboard

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamic_appointment_application.R
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentSelectBusinessBinding
import com.example.dynamic_appointment_application.extensions.getSnapPosition
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectBusinessFragment :
    BaseFragment<FragmentSelectBusinessBinding>(FragmentSelectBusinessBinding::inflate) {
    private var map: GoogleMap? = null
    private val selectBusinessViewModel: SelectBusinessViewModel by viewModel()
    private val businessRecyclerViewAdapter =
        BusinessesRecyclerViewAdapter(listOf()) { selectedBusinessId ->
            val navigationBundle = bundleOf(
                "businessId" to selectedBusinessId,
                "serviceId" to arguments?.getString("selectedServiceId")
            )
            navigate(
                R.id.action_fragment_select_business_to_fragment_select_professional,
                navigationBundle
            )
        }

    override fun FragmentSelectBusinessBinding.onViewCreated(savedInstanceState: Bundle?) {
        arguments?.getString("selectedServiceId")
            ?.let { selectBusinessViewModel.getBusinessesByServiceId(it) }
        selectBusinessViewModel.businessListLiveData.observe(viewLifecycleOwner) { items ->
            businessRecyclerViewAdapter.setItems(items)
            businessRecyclerViewAdapter.getItems().forEach { business ->
                map?.addMarker(
                    MarkerOptions().position(
                        LatLng(
                            business.latitude ?: 0.0,
                            business.longitude ?: 0.0
                        )
                    )
                )
            }
        }
        val supportMapFragment: SupportMapFragment =
            childFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment
        supportMapFragment.getMapAsync {
            map = it
            map?.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(45.0, 30.0),
                    5.0F
                )
            )
        }
        businessesRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        businessesRecyclerView.adapter = businessRecyclerViewAdapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(businessesRecyclerView)

        businessesRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            private var snapPosition = RecyclerView.NO_POSITION
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                maybeNotifySnapPositionChange(recyclerView)

            }

            private fun maybeNotifySnapPositionChange(recyclerView: RecyclerView) {
                val snapPosition = snapHelper.getSnapPosition(recyclerView)
                val snapPositionChanged = this.snapPosition != snapPosition
                if (snapPositionChanged) {
                    val currentBusiness = businessRecyclerViewAdapter.getItems()[snapPosition]
                    navigateMapTo(
                        LatLng(
                            currentBusiness.latitude ?: 0.0,
                            currentBusiness.longitude ?: 0.0
                        )
                    )
                    this.snapPosition = snapPosition
                }
            }
        })
    }

    private fun navigateMapTo(latLng: LatLng) {
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0F))
        if (map == null) {
            showToast("map is null")
        }
    }
}