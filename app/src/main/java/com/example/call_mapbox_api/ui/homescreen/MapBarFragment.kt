package com.example.call_mapbox_api.ui.homescreen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.call_mapbox_api.databinding.FragmentMapbarBinding
import com.example.call_mapbox_api.util.showKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapBarFragment : Fragment() {

    private var _binding: FragmentMapbarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchBar = binding.searchbarFragment.inputSearch
        searchBar.focusable = View.NOT_FOCUSABLE
        searchBar.setOnClickListener {
            context?.let {
                showKeyboard(view, it)
            }
            //searchBar.focusable = View.FOCUSABLE
            view.findNavController().navigate(createMapBarFragmentDirections())
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
