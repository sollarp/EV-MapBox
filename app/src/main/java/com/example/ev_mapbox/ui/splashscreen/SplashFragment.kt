package com.example.ev_mapbox.ui.splashscreen

import android.Manifest
import android.content.pm.PackageManager
<<<<<<< HEAD
=======
import android.location.LocationManager
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.ev_mapbox.databinding.FragmentSplashBinding
import com.example.ev_mapbox.domain.model.LoadingState
import com.example.ev_mapbox.ui.searchscreen.SearchListFragmentDirections
import com.example.ev_mapbox.ui.searchscreen.SearchListViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    private val locationPermissionCode = 2
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // Check for location permission
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Request location updates
            fusedLocationClient.lastLocation.addOnSuccessListener(
                requireActivity()
            ) { location ->
                // Use location data here
                val latitude = location?.latitude
                val longitude = location?.longitude
                // TODO: Do something with the latitude and longitude values
<<<<<<< HEAD
                println("get location on: $latitude, $longitude")
=======
                println("get location on: ${latitude}, ${longitude}")
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
            }
        } else {
            // Request location permission
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                locationPermissionCode
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call API here and wait for response
        viewModel.getAllPoints()
        getLoadingState()

    }

    private fun getLoadingState() {
        viewModel.loadingStateLiveData.observe(viewLifecycleOwner) { loadingState ->
            when (loadingState) {
                LoadingState.LOADING -> {
                    println("LoadingStatus1")
                    view?.findNavController()?.navigate(createSplashFragmentDirections())
                }
                LoadingState.LOADED -> {
                    println("LoadingStatus2")

                }
                LoadingState.ERROR -> {
                    println("LoadingStatus3")
                }
                null -> {
                    println("LoadingStatus is null")
                }
            }
        }
    }

    private fun createSplashFragmentDirections(): NavDirections {
        return SearchListFragmentDirections
            .actionSplashFragmentToMapBarFragment()
    }
}