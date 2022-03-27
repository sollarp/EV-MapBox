package com.example.evmapbox

// API KEY store https://docs.mapbox.com/help/troubleshooting/private-access-token-android-and-ios/
// https://www.youtube.com/watch?v=X8lYNW_Or2o
import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import com.example.evmapbox.data.EvRepoImpl
import com.example.evmapbox.data.remote.OpenMapApi
import com.example.evmapbox.data.testImpl
import com.example.evmapbox.databinding.ActivityMainBinding
import com.example.evmapbox.di.AppModule
import com.example.evmapbox.domain.model.EvPointItems
import com.example.evmapbox.domain.repository.EvMapRepo
import com.example.evmapbox.domain.use_case.GetEvPointUseCase
import com.example.evmapbox.presentation.EvListState
import com.example.evmapbox.presentation.EvPointViewModel
import com.mapbox.maps.MapView
import com.mapbox.maps.Observer
import com.mapbox.maps.Style
import dagger.Module
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ViewModelScoped
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
    private lateinit var getEvPointUseCase: GetEvPointUseCase
    private lateinit var appModule: AppModule
    private lateinit var evMapRepo: EvMapRepo
    private lateinit var evListState: EvListState


    private val viewModel: EvPointViewModel by viewModels()

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
        //main()
        startFun()


    }
    fun startFun() {
        viewModel.state.observe(this) {EvPointItems ->
            binding.apply {
                textView.text = EvPointItems.points.map { it.connections }.toString()
                //Log.d("mapView", "talald meg ${evPointItems.addressInfo?.latitude.toString()}")
            }
        }
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