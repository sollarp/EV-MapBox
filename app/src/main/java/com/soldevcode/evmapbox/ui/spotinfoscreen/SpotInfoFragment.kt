package com.soldevcode.evmapbox.ui.spotinfoscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.soldevcode.evmapbox.ui.searchscreen.SearchListViewModel
import com.soldevcode.evmapbox.util.Constants
import com.soldevcode.evmapbox.util.getNavigationIntent
import com.google.android.gms.maps.model.LatLng
import com.soldevcode.evmapbox.R
import com.soldevcode.evmapbox.databinding.FragmentSpotInfoBinding

class SpotInfoFragment: Fragment()  {
    private var _binding: FragmentSpotInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchListViewModel by activityViewModels()

    private var btnSpotNav: Button? = null
    private var btnSpotLeft: Button? = null

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
        btnSpotNav = binding.btnSpotNav
        btnSpotLeft = binding.btnSpotLeft
        viewModel.getDetailItems().observe(viewLifecycleOwner) { detailItems ->
            binding.txtBusinessCenter.text = detailItems.Title
            val address = detailItems.AddressLine1
            val town = "${detailItems.Town}, " +
                    "${detailItems.Postcode}"
            val addressAndTownText = resources.getString(R.string.address_and_town, address, town)
            val latLng = detailItems.Longitude?.let {
                detailItems.Latitude?.let { it1 ->
                    LatLng(
                        it,
                        it1
                    )
                }
            }
            btnSpotNav?.setOnClickListener {
                val intent = getNavigationIntent(latLng)
                context?.startActivity(intent)
            }
            btnSpotLeft?.setOnClickListener {
                findNavController().popBackStack()
            }

            binding.txtSpotAddress.text = addressAndTownText

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
