package com.example.evmapbox

// API KEY store https://docs.mapbox.com/help/troubleshooting/private-access-token-android-and-ios/
// https://www.youtube.com/watch?v=X8lYNW_Or2o
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.example.evmapbox.data.EvRepoImpl
import com.example.evmapbox.data.remote.OpenMapApi
import com.example.evmapbox.data.remote.OpenMapDto.ChargingPointsAllItem
import com.example.evmapbox.data.testImpl
import com.example.evmapbox.databinding.ActivityMainBinding
import com.example.evmapbox.di.AppModule
import com.example.evmapbox.domain.model.EvPointItems
import com.example.evmapbox.domain.repository.EvMapRepo
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

var mapView: MapView? = null

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var evPointItems : EvPointItems

    // Inject Retrofit instance
    //@Inject
    @Inject
    lateinit var getApiRespond: EvRepoImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = findViewById(R.id.mapView)
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
        main()

    }

    @DelicateCoroutinesApi
    private fun main() { GlobalScope.launch { getApiRespond.getResponse()
        println("Hello")

        Log.d("mapView", "talald meg ${evPointItems.addressInfo}")

    }
}


    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }
}