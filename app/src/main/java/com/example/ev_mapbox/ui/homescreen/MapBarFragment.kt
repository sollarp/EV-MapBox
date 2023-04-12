package com.example.ev_mapbox.ui.homescreen

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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
import com.example.ev_mapbox.util.getNavigationIntent
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MapBarFragment : Fragment(),
    OnMarkerClickListener,
    OnMapReadyCallback{

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
    private var textDistance: TextView? = null
    private var btnPosNav: ImageButton? = null

    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var map: GoogleMap
    private lateinit var locationButton: View
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapbarBinding.inflate(inflater, container, false)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetView = binding.root.findViewById(R.id.layout_cardview)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView)
        textAddress = binding.root.findViewById(R.id.txtAddress)
        textPointsCounter = binding.root.findViewById(R.id.txtPointsCounter)
        textTitle = binding.root.findViewById(R.id.txtTitle)
        textDistance = binding.root.findViewById(R.id.txtDistance)
        btnPosNav = binding.root.findViewById(R.id.btnNav)
        val btn = binding.root.findViewById<FloatingActionButton>(R.id.my_location_button)
        btn.setOnClickListener {
            getLastLocation()
        }

        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        binding.searchbarLayout.inputSearch.focusable = View.NOT_FOCUSABLE
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pointsMediatorData.observe(viewLifecycleOwner) { pointItems ->
                    supportMapFragment.getMapAsync {
                        pointsEntity = pointItems
                        //it.isMyLocationEnabled
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
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            view.findNavController().navigate(createMapBarFragmentDirections())
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        // Get the vector drawable resource
        val vectorDrawable =
            context?.let { ContextCompat.getDrawable(it, R.drawable.pulsing_location) }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable!!.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        // Create an animation that cycles through a set of images

        fusedLocationClient.lastLocation.addOnSuccessListener(
            requireActivity()
        ) { location ->
            val currentLocation = LatLng(
                51.5872529,-1.4423977
                /*location.latitude,
                location.longitude*/
            )
            val markerOptions = MarkerOptions()
                .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                .position(currentLocation)
            map.addMarker(markerOptions)
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 14F))

        }
    }

    private fun isPermissionGranted(): Boolean {
        return context?.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        } == PackageManager.PERMISSION_GRANTED
    }

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
        } else {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        addMarkers(map)
        map.setOnMarkerClickListener(this)
        //enableMyLocation()
        getLastLocation()
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
        val address = pointId.AddressInfo.AddressLine1
        val town = pointId.AddressInfo.Town
        val title = pointId.AddressInfo.Title
        val pointsCounterText = String.format(
            resources.getString(R.string.points),
            pointId.NumberOfPoints.toString()
        )
        val addressAndTownText = resources.getString(R.string.address_and_town, address, town)
        textAddress?.text = addressAndTownText
        textPointsCounter?.text = pointsCounterText
        textTitle?.text = title
        textDistance?.text = String.format(
            "%.2f Miles",
            pointId.AddressInfo.Distance
        )
        val latLng = pointId.AddressInfo.Latitude?.let {
            pointId.AddressInfo.Longitude?.let { it1 ->
                LatLng(
                    it,
                    it1
                )
            }
        }
        btnPosNav?.setOnClickListener {
            val intent = getNavigationIntent(latLng)
            context?.startActivity(intent)
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        val vectorDrawable =
            context?.let { ContextCompat.getDrawable(it, R.drawable.map_markers) }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable!!.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        pointsEntity.forEach { point ->
            val marker = googleMap
                .addMarker(
                    MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
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
}