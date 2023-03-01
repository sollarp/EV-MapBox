package com.example.ev_mapbox.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel
import com.example.ev_mapbox.R
import com.example.ev_mapbox.databinding.FragmentMapbarBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.launch

class MapBarFragment : Fragment() {

    private var _binding: FragmentMapbarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapbarBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        binding.searchbarFragment.inputSearch.focusable = View.NOT_FOCUSABLE
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pointsMediatorData.observe(viewLifecycleOwner) { pointItems ->
                    supportMapFragment.getMapAsync { googleMap ->
                        addMarkers(googleMap, pointItems)
                        googleMap.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    51.667683,
                                    -1.327816
                                    /*pointItems[0].AddressInfo.Latitude!!.toDouble(),
                                    pointItems[0].AddressInfo.Longitude!!.toDouble()*/
                                ), 10f
                            )
                        )
                    }
                }
            }
        }
        binding.searchbarFragment.inputSearch.setOnClickListener {
            view.findNavController().navigate(createMapBarFragmentDirections())
        }
    }
    private fun addMarkers(googleMap: GoogleMap, pointItems: List<EvPointsEntity>) {
        pointItems.forEach { point ->
            googleMap.addMarker(
                MarkerOptions()
                    .title(point.AddressInfo.Title)
                    .position(
                        LatLng(
                            point.AddressInfo.Latitude!!.toDouble(),
                            point.AddressInfo.Longitude!!.toDouble()
                        )
                    )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun createMapBarFragmentDirections(): NavDirections {
        return MapBarFragmentDirections.actionMapBarFragmentToSearchlistFragment()
    }
}

