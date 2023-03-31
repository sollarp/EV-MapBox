package com.example.ev_mapbox.ui.homescreen

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.ev_mapbox.ui.searchscreen.SearchListViewModel
import com.example.ev_mapbox.R
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.databinding.FragmentMapbarBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.launch

class MapBarFragment : Fragment(),
    OnMarkerClickListener,
    OnMapReadyCallback,
    GoogleMap.OnMyLocationClickListener,
    GoogleMap.OnMyLocationButtonClickListener {

    private var _binding: FragmentMapbarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    private lateinit var bottomSheetView: RelativeLayout
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<RelativeLayout>
    private lateinit var pointsEntity: List<EvPointsEntity>
    private var lastClickedMarker: Marker? = null

    private var textAddress: TextView? = null
    private var textPointsCounter: TextView? = null
    private var textTitle: TextView? = null

    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var map: GoogleMap
<<<<<<< HEAD
    private lateinit var locationButton: View
=======
    val pulseMarkerBitmap = BitmapDescriptorFactory.fromResource(R.drawable.pulse_marker)
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059

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

        textAddress = binding.root.findViewById(R.id.txtAddress)
        textPointsCounter = binding.root.findViewById(R.id.txtPointsCounter)
        textTitle = binding.root.findViewById(R.id.txtTitle)

        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        binding.searchbarLayout.inputSearch.focusable = View.NOT_FOCUSABLE
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pointsMediatorData.observe(viewLifecycleOwner) { pointItems ->
                    supportMapFragment.getMapAsync {
                        pointsEntity = pointItems
<<<<<<< HEAD
                        //it.isMyLocationEnabled
=======
                        it.isMyLocationEnabled
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
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
    private fun isPermissionGranted() : Boolean {
        return context?.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION)
        } == PackageManager.PERMISSION_GRANTED
    }

<<<<<<< HEAD
    private fun isPermissionGranted(): Boolean {
        return context?.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        } == PackageManager.PERMISSION_GRANTED
    }

=======
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            if (context?.let {
                    ActivityCompat.checkSelfPermission(
                        it,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                } != PackageManager.PERMISSION_GRANTED && context?.let {
                    ActivityCompat.checkSelfPermission(
                        it,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                } != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            map.isMyLocationEnabled = true
<<<<<<< HEAD
        } else {
=======
        }
        else {
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }
<<<<<<< HEAD

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        addMarkers(map)
        map.setOnMarkerClickListener(this)
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableMyLocation()
        /* map.uiSettings.isMyLocationButtonEnabled = true
         locationButton = (binding.root.findViewById<View>(Integer.parseInt("1")).parent as View).findViewById(Integer.parseInt("2"))
         locationButton.visibility = View.GONE*/
=======
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        addMarkers(map)
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableMyLocation()
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
        /*Using this method may override behaviors set by the Maps SDK for Android Utility Library.
        If you are not using clustering, GeoJson, or KML, you can safely suppress this warning,
        otherwise, refer to the utility library's migration guide: https://bit.ly/3kTpQmY*/
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        if (lastClickedMarker == marker) {
            // Marker is already selected, toggle bottom sheet state
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                setCardViewTexts(marker)
            }
        } else {
            // New marker selected, expand bottom sheet
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            Handler().postDelayed({
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                setCardViewTexts(marker)
            }, 250)
            lastClickedMarker = marker
        }
        return false
    }

    private fun setCardViewTexts(marker: Marker) {
        val pointId: EvPointsEntity = marker.tag as EvPointsEntity
        val numberOfPoints = pointId.NumberOfPoints
        val address = pointId.AddressInfo.AddressLine1
        val town = pointId.AddressInfo.Town
        val title = pointId.AddressInfo.Title
        val pointsCounterText = resources.getString(R.string.points_counter, numberOfPoints)
        val addressAndTownText = resources.getString(R.string.address_and_town, address, town)
        textAddress?.text = addressAndTownText
        textPointsCounter?.text = pointsCounterText
        textTitle?.text = title
    }

    private fun addMarkers(googleMap: GoogleMap) {
        pointsEntity.forEach { point ->
            val marker = googleMap
                .addMarker(
                    MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker48))
                        .title(point.AddressInfo.Title)
                        .position(
                            LatLng(
                                point.AddressInfo.Latitude!!.toDouble(),
                                point.AddressInfo.Longitude!!.toDouble()
                            )
                        )
                )
            marker?.tag = point
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createMapBarFragmentDirections(): NavDirections {
        return MapBarFragmentDirections.actionMapBarFragmentToSearchlistFragment()
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(context, "MyLocation button clicked", Toast.LENGTH_SHORT)
            .show()
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false
    }

    override fun onMyLocationClick(location: Location) {
        Toast.makeText(context, "Current location:\n$location", Toast.LENGTH_LONG)
            .show()
    }

}