package com.soldevcode.evmapbox.ui.splashscreen

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.soldevcode.evmapbox.databinding.FragmentSplashBinding
import com.soldevcode.evmapbox.domain.model.LoadingState
import com.soldevcode.evmapbox.ui.searchscreen.SearchListFragmentDirections
import com.soldevcode.evmapbox.ui.searchscreen.SearchListViewModel
import com.soldevcode.evmapbox.util.LocationProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.soldevcode.evmapbox.util.Constants.LOCATION_PERMISSION_REQUEST_CODE
import com.soldevcode.evmapbox.util.LocationPermission

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLocationPermissions()
    }

    private fun onRequestPermissionLauncher(): ActivityResultLauncher<Array<String>> {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (permissions.all { it.value }) {
                getLocationPermissions()
            } else {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Location Permission Required")
                builder.setMessage("This application requires location permission to function properly.")
                builder.setPositiveButton("Grant Permission") { _, _ ->
                    LocationPermission.requestLocationPermissions(requireActivity(), LOCATION_PERMISSION_REQUEST_CODE)
                    getLocationPermissions()
                }
                builder.setNegativeButton("Deny Permission") { _, _ ->
                    requireActivity().finish()
                }
                val dialog = builder.create()
                dialog.show()
            }
        }
        return requestPermissionLauncher
    }

    @SuppressLint("MissingPermission")
    private fun getLocationPermissions() {
        if (activity?.let { LocationPermission.isLocationPermissionsGranted(it) } == true) {
            onRequestPermissionLauncher().launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener(
                requireActivity()
            ) { location ->
                // Use location data here
                LocationProvider.latitude = location.latitude
                LocationProvider.longitude = location.longitude
                viewModel.getAllPoints()
                getLoadingState()
            }
        }
    }

    private fun getLoadingState() {
        viewModel.loadingStateLiveData.observe(viewLifecycleOwner) { loadingState ->
            when (loadingState) {
                LoadingState.LOADING -> {
                    view?.findNavController()?.navigate(createSplashFragmentDirections())
                }
                LoadingState.LOADED -> {
                    println("Loaded")

                }
                LoadingState.ERROR -> {
                    println("Error")
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