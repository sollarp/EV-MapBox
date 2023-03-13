package com.example.ev_mapbox.ui.homescreen

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel
import com.example.ev_mapbox.R
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.databinding.FragmentMapbarBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.launch


class MapBarFragment : Fragment(), OnMarkerClickListener, OnMapReadyCallback {

    private var _binding: FragmentMapbarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    private lateinit var bottomSheetView: RelativeLayout
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<RelativeLayout>
    private lateinit var pointsEntity: List<EvPointsEntity>
    private var lastClickedMarker: Marker? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetView = binding.root.findViewById(R.id.layout_cardview)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView)
        
        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        binding.searchbarLayout.inputSearch.focusable = View.NOT_FOCUSABLE
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pointsMediatorData.observe(viewLifecycleOwner) { pointItems ->
                    supportMapFragment.getMapAsync {
                        pointsEntity = pointItems
                        onMapReady(it)
                        it.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    51.667683, -1.327816
                                    /*pointItems[0].AddressInfo.Latitude!!.toDouble(),
                                    pointItems[0].AddressInfo.Longitude!!.toDouble()*/
                                ), 10f
                            )
                        )
                    }
                }
            }
        }
        binding.searchbarLayout.inputSearch.setOnClickListener {
            view.findNavController().navigate(createMapBarFragmentDirections())
        }
    }

    override fun onMapReady(map: GoogleMap) {
        addMarkers(map)
        /*Using this method may override behaviors set by the Maps SDK for Android Utility Library.
        If you are not using clustering, GeoJson, or KML, you can safely suppress this warning,
        otherwise, refer to the utility library's migration guide: https://bit.ly/3kTpQmY*/

        map.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        if (lastClickedMarker == marker) {
            // Marker is already selected, toggle bottom sheet state
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                println("bottomSheet Collapsed ${marker.tag}")
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        } else {
            // New marker selected, expand bottom sheet
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            Handler().postDelayed({
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                println("bottomSheet Expanded ${marker.tag}")
            }, 250)
            lastClickedMarker = marker
        }
        return false
    }

    private fun addMarkers(googleMap: GoogleMap) {
        pointsEntity.forEach { point ->
            val marker = googleMap.addMarker(
                    MarkerOptions().title(point.AddressInfo.Title).position(
                            LatLng(
                                point.AddressInfo.Latitude!!.toDouble(),
                                point.AddressInfo.Longitude!!.toDouble()
                            )
                        )
                )
            marker?.tag = point.ID
        }
    }

    private fun setBottomSheetVisibility(isVisible: Boolean) {
        val updatedState =
            if (isVisible) BottomSheetBehavior.STATE_EXPANDED else BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.state = updatedState

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createMapBarFragmentDirections(): NavDirections {
        return MapBarFragmentDirections.actionMapBarFragmentToSearchlistFragment()
    }

}