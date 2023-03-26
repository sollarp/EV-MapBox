package com.example.ev_mapbox.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.ev_mapbox.databinding.FragmentSplashBinding
import com.example.ev_mapbox.domain.model.LoadingState
import com.example.ev_mapbox.ui.searchscreen.SearchListFragmentDirections
import com.example.ev_mapbox.ui.searchscreen.SearchListViewModel

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
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