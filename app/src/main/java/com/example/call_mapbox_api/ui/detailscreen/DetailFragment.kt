package com.example.call_mapbox_api.ui.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.databinding.FragmentDetailBinding
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel


class DetailFragment : Fragment() {

    private var fragmentDetailBinding: FragmentDetailBinding? = null
    private val viewModel: SearchListViewModel by activityViewModels { SearchListViewModel.Factory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        fragmentDetailBinding = binding
        viewModel.getDetailItems().observe(viewLifecycleOwner) { it ->

            val add1 = view.findViewById<TextView>(R.id.addressline1)
            val add2 = view.findViewById<TextView>(R.id.addressline2)
            val town = view.findViewById<TextView>(R.id.town)
            val tile = view.findViewById<TextView>(R.id.title)
            val cost = view.findViewById<TextView>(R.id.usage_cost)
            val bays = view.findViewById<TextView>(R.id.number_of_bays)
            val postCode = view.findViewById<TextView>(R.id.postcode)
            val lon = view.findViewById<TextView>(R.id.latitude)
            val lat = view.findViewById<TextView>(R.id.longitude)
            val lastUpdate = view.findViewById<TextView>(R.id.dateLastStatusUpdate)

            add1.text = it.AddressLine1
            add2.text = it.AddressLine2
            town.text = it.Town
            tile.text = it.Postcode
            cost.text = it.UsageCost
            bays.text = it.NumberOfPoints.toString()
            postCode.text = it.Title
            lon.text = it.Longitude.toString()
            lat.text = it.Latitude.toString()
            lastUpdate.text = it?.DateLastStatusUpdate

            val adapter = it?.Connection?.let { DetailRecycleAdapter(it) }
            val recyclerView = view.findViewById<RecyclerView>(R.id.connection_recycler)
            recyclerView.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            recyclerView.adapter = adapter
        }
        return view
    }
}