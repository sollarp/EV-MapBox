package com.example.ev_mapbox.ui.spotinfoscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ev_mapbox.R
import com.example.ev_mapbox.databinding.FragmentSpotInfoBinding
import com.example.ev_mapbox.ui.searchscreen.SearchListViewModel
import com.example.ev_mapbox.util.Constants

class SpotInfoFragment: Fragment()  {
    private var _binding: FragmentSpotInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpotInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDetailItems().observe(viewLifecycleOwner) { detailItems ->
            binding.txtBusinessCenter.text = detailItems.Title
            val address = detailItems.AddressLine1
            val town = "${detailItems.Town}, " +
                    "${detailItems.Postcode}"
            val addressAndTownText = resources.getString(R.string.address_and_town, address, town)

            binding.txtSpotAddress.text = addressAndTownText
            /*binding.addressline2.text = detailItems.AddressLine2
            binding.town.text = detailItems.Town
            binding.title.text = detailItems.Postcode
            binding.usageCost.text = detailItems.UsageCost
            binding.numberOfBays.text = detailItems.NumberOfPoints.toString()
            binding.postcode.text = detailItems.Title
            binding.longitude.text = detailItems.Longitude.toString()
            binding.latitude.text = detailItems.Latitude.toString()
            binding.dateLastStatusUpdate.text = detailItems.DateLastStatusUpdate*/

            binding.recyclerGridjcounter.apply {
                layoutManager =
                    StaggeredGridLayoutManager(Constants.SPAN_COUNT_2, StaggeredGridLayoutManager.HORIZONTAL)
                adapter = detailItems.Connection?.let { SpotInfoRecycleAdapter(it, detailItems.UsageCost) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
