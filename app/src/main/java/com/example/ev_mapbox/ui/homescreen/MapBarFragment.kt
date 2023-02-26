package com.example.ev_mapbox.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel
import com.example.ev_mapbox.R
import com.example.ev_mapbox.databinding.FragmentMapbarBinding
import com.example.ev_mapbox.ui.searchscreen.SearchListFragment
import com.example.ev_mapbox.util.hideKeyboard
import com.example.ev_mapbox.util.showKeyboard
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
            childFragmentManager.findFragmentById(R.id.googlemap_fragment) as SupportMapFragment
        val backStackEntry = childFragmentManager.backStackEntryCount

        //binding.searchbarFragment.inputSearch.focusable = View.NOT_FOCUSABLE

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pointsMediatorData.observe(viewLifecycleOwner) { pointItems ->
                    supportMapFragment.getMapAsync { googleMap ->
                        addMarkers(googleMap, pointItems)
                        googleMap.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    pointItems[0].AddressInfo.Latitude!!.toDouble(),
                                    pointItems[0].AddressInfo.Longitude!!.toDouble()
                                ), 10f
                            )
                        )
                    }
                }
            }
        }
        binding.searchbarFragment.inputSearch.apply {
            doOnTextChanged { text, _, _, _ ->
                viewModel.onSearchQuery(text.toString())
            }
            setOnClickListener {
                //context?.let { hideKeyboard(view, it) }
                if(backStackEntry == 0){
                    childFragmentManager.commit {
                        replace<SearchListFragment>(R.id.googlemap_fragment)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                }
            }
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
}
