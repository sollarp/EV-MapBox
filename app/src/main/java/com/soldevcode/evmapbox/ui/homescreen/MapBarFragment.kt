package com.soldevcode.evmapbox.ui.homescreen

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.google.android.gms.location.*
import com.soldevcode.evmapbox.R
import com.soldevcode.evmapbox.databinding.FragmentMapbarBinding
import com.soldevcode.evmapbox.ui.searchscreen.SearchListViewModel
import com.soldevcode.evmapbox.data.local.EvPointsEntity
import com.soldevcode.evmapbox.domain.model.itemDataConverter
import com.soldevcode.evmapbox.util.getNavigationIntent
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
    OnMapReadyCallback {

    private var _binding: FragmentMapbarBinding? = null
    private val binding get() = _binding!!
    private val searchListViewModel: SearchListViewModel by activityViewModels()
    private val mapBarViewModel: MapBarViewModel by activityViewModels()

    private lateinit var bottomSheetView: RelativeLayout
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<RelativeLayout>
    private lateinit var pointsEntity: List<EvPointsEntity>

    private var textAddress: TextView? = null
    private var textPointsCounter: TextView? = null
    private var textTitle: TextView? = null
    private var textDistance: TextView? = null
    private var btnPosNav: ImageButton? = null
    private var cardView: CardView? = null

    private lateinit var map: GoogleMap
    private var clickedMarker: Marker? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var lastClickedMarkerLocation: LatLng? = null
    private var currentLocation: LatLng? = null
    private lateinit var locationCallback: LocationCallback
    private var myLocationMarker: Marker? = null

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
        textPointsCounter = binding.root.findViewById(R.id.txtCardPointsCounter)
        textTitle = binding.root.findViewById(R.id.txtTitle)
        textDistance = binding.root.findViewById(R.id.txtDistance)
        btnPosNav = binding.root.findViewById(R.id.btnNav)
        cardView = binding.root.findViewById(R.id.item_popcardview)

        val btn = binding.root.findViewById<FloatingActionButton>(R.id.my_location_button)
        btn.setOnClickListener {
            getUserLocation()
        }
        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        binding.searchbarLayout.inputSearch.focusable = View.NOT_FOCUSABLE
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                searchListViewModel.pointsMediatorData.observe(viewLifecycleOwner) { pointItems ->
                    supportMapFragment.getMapAsync {
                        pointsEntity = pointItems
                        onMapReady(it)
                    }
                }
            }
        }
        binding.searchbarLayout.inputSearch.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            view.findNavController().navigate(createSearchListFragmentDirections())
        }
        setCardViewTexts()
    }

    private fun getUserLocation() {
        mapBarViewModel.getCurrentLocation().observe(viewLifecycleOwner) {
            currentLocation
        }
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation!!, 15F))
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        // Get the vector drawable resource
        if (lastClickedMarkerLocation == null) {
            val vectorDrawable =
                context?.let { ContextCompat.getDrawable(it, R.drawable.pulsing_location) }
            val bitmap = Bitmap.createBitmap(
                vectorDrawable!!.intrinsicWidth,
                vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
            vectorDrawable.draw(canvas)

            fusedLocationClient.lastLocation.addOnSuccessListener(
                requireActivity()
            ) { location ->
                currentLocation = LatLng(
                    location.latitude,
                    location.longitude
                )
                val markerOptions = MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                    .position(currentLocation!!)
                    .anchor(0.5f, 0.5f)
                    .title("You")
                myLocationMarker = map.addMarker(markerOptions)
                if(clickedMarker == null){
                    startLocationUpdates()
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation!!, 15F))
                }
                mapBarViewModel.setLastClickedLocation(currentLocation!!)
                lastClickedMarkerLocation = currentLocation
                mapBarViewModel.setCurrentLocation(currentLocation!!)
            }
        } else {
            mapBarViewModel.getLastClickedLocation().observe(viewLifecycleOwner) {
                lastClickedMarkerLocation
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        addMarkers(map)
        map.setOnMarkerClickListener(this)
        getLocation()
        setCardViewTexts()
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        if (clickedMarker == marker) {
            val newState = if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                BottomSheetBehavior.STATE_COLLAPSED
            } else {
                BottomSheetBehavior.STATE_EXPANDED
            }
            bottomSheetBehavior.state = newState
            if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                setCardViewTexts()
            }
        } else {
            clickedMarker = marker
            mapBarViewModel.setLastClickedLocation(marker.position)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            Handler().postDelayed({
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                setCardViewTexts()
            }, 250)
        }
        clickedMarker?.let { mapBarViewModel.setMarker(it) }
        return false
    }


    private fun setCardViewTexts() {
        clickedMarker = mapBarViewModel.getMarker()
        val pointId = clickedMarker?.tag as? EvPointsEntity
        if (pointId != null) {
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
            cardView?.setOnClickListener {
                searchListViewModel.setDetailItems(itemDataConverter(pointId))
                view?.findNavController()?.navigate(createSpotInfoFragmentDirections())
            }
        } else {
            // Handle the case when marker is the user current location.
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
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

    private fun startLocationUpdates() {
        val locationRequest = LocationRequest.create().apply {
            interval = 1000
            fastestInterval = 500
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult ?: return
                val location = locationResult.lastLocation
                // Update the marker position
                myLocationMarker?.position = LatLng(location.latitude, location.longitude)
                currentLocation = myLocationMarker?.position
            }
        }
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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createSearchListFragmentDirections(): NavDirections {
        return MapBarFragmentDirections.actionMapBarFragmentToSearchlistFragment()
    }

    private fun createSpotInfoFragmentDirections(): NavDirections {
        return MapBarFragmentDirections
            .actionMapBarFragmentToSpotinfoFragment()
    }
}