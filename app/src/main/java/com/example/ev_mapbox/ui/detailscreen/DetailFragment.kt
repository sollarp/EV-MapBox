package com.example.ev_mapbox.ui.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ev_mapbox.databinding.FragmentDetailBinding
import com.example.ev_mapbox.ui.searchscreen.SearchListViewModel
import com.example.ev_mapbox.util.Constants.SPAN_COUNT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: SearchListViewModel by activityViewModels()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDetailItems().observe(viewLifecycleOwner) { detailItems ->
            binding.addressline1.text = detailItems.AddressLine1
            binding.addressline2.text = detailItems.AddressLine2
            binding.town.text = detailItems.Town
            binding.title.text = detailItems.Title
            binding.usageCost.text = detailItems.UsageCost
            binding.numberOfBays.text = detailItems.NumberOfPoints.toString()
            binding.postcode.text = detailItems.Postcode
            binding.longitude.text = detailItems.Longitude.toString()
            binding.latitude.text = detailItems.Latitude.toString()
            binding.dateLastStatusUpdate.text = detailItems.DateLastStatusUpdate

            binding.connectionRecycler.apply {
                layoutManager =
                    StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
                adapter = detailItems.Connection?.let { DetailRecycleAdapter(it) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
