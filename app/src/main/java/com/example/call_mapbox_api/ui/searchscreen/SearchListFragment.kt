package com.example.call_mapbox_api.ui.searchscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.databinding.FragmentSearchListBinding
import com.example.call_mapbox_api.util.ItemDataConverter
import com.example.call_mapbox_api.util.SPAN_COUNT
import com.example.call_mapbox_api.util.hideKeyboard
import com.example.call_mapbox_api.util.itemDataConverter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchListFragment : Fragment() {

    private val viewModel: SearchListViewModel by activityViewModels()
    private var _binding: FragmentSearchListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recycleSearch
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                context?.let { hideKeyboard(view, it) }
            }
        })
        createAdapterObserver(view, recyclerView, viewLifecycleOwner)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createAdapterObserver(
        view: View,
        recyclerView: RecyclerView,
        viewLifecycleOwner: LifecycleOwner
    ): Job {
        return viewLifecycleOwner
            .lifecycleScope
            .launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.listOfItems
                        .observe(
                            viewLifecycleOwner, Observer
                            {
                                val adapter = createSearchRecycleAdapter(
                                    it,
                                    ::itemDataConverter,
                                    view,
                                )
                                recyclerView.layoutManager =
                                    StaggeredGridLayoutManager(
                                        SPAN_COUNT,
                                        StaggeredGridLayoutManager.VERTICAL,
                                    )
                                recyclerView.adapter = adapter
                            }
                        )
                }
            }
    }

    private fun createSearchRecycleAdapter(
        items: List<EvPointsEntity>,
        itemDataConverter: (EvPointsEntity) -> ItemDataConverter,
        view: View
    ): SearchRecycleAdapter {
        return SearchRecycleAdapter(
            items,
            object : SearchRecycleAdapter.OnAdapterListener {
                override fun onClick(address: EvPointsEntity) {
                    viewModel.setDetailItems(itemDataConverter(address))
                    view.findNavController().navigate(createSearchListFragmentDirections())
                }
            }
        )
    }

    private fun createSearchListFragmentDirections(): NavDirections {
        return SearchListFragmentDirections
            .actionSearchlistFragmentToDetailFragment()
    }
}


