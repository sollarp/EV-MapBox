package com.soldevcode.evmapbox.ui.splashscreen

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
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
        requestLocationPermissions()
    }

    private fun onRequestPermissionLauncher(): ActivityResultLauncher<Array<String>> {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (permissions.all { it.value }) {
                requestLocationPermissions()
            } else {
                requestLocationPermissions()
            }
        }
        return requestPermissionLauncher
    }

    private fun requestLocationPermissions() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
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
                    println("Loading")
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