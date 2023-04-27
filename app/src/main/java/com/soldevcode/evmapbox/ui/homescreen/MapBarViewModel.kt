package com.soldevcode.evmapbox.ui.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

class MapBarViewModel: ViewModel() {

    private val currentLocationLiveData = MutableLiveData<LatLng>()
    private val lastClickedLocationLiveData = MutableLiveData<LatLng>()
    private var marker: Marker? = null

    fun setMarker(marker: Marker) {
        this.marker = marker
    }

    fun getMarker(): Marker? {
        return marker
    }

    fun setCurrentLocation(location: LatLng) {
        currentLocationLiveData.value = location
    }

    fun getCurrentLocation(): LiveData<LatLng> {
        return currentLocationLiveData
    }

    fun getLastClickedLocation(): MutableLiveData<LatLng> {
        return lastClickedLocationLiveData
    }

    fun setLastClickedLocation(location: LatLng) {
        lastClickedLocationLiveData.value = location
    }
}