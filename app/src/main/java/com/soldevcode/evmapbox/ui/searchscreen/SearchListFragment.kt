package com.soldevcode.evmapbox.ui.searchscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.soldevcode.evmapbox.databinding.FragmentSearchlistBinding
import com.soldevcode.evmapbox.data.local.EvPointsEntity
import com.soldevcode.evmapbox.domain.model.ItemDataConverter
import com.soldevcode.evmapbox.domain.model.itemDataConverter
import com.soldevcode.evmapbox.util.Constants
import com.soldevcode.evmapbox.util.hideKeyboard
import com.soldevcode.evmapbox.util.showKeyboardDelayed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchListFragment : Fragment() {

    private val viewModel: SearchListViewModel by activityViewModels()
    private var _binding: FragmentSearchlistBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recycleSearch

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    context?.let { hideKeyboard(view, it) }
                }
            }
        })
        binding.searchlistLayout.inputSearch.doOnTextChanged { text, _, _, _ ->
            viewModel.onSearchQuery(text.toString())
        }
        val editText = binding.searchlistLayout.inputSearch
        editText.requestFocus()
        editText.showKeyboardDelayed()
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
    ) {
        return viewModel.pointsMediatorData
            .observe(
                viewLifecycleOwner, Observer
                {
                    val adapter = createSearchRecycleAdapter(
                        it as ArrayList<EvPointsEntity>,
                        ::itemDataConverter,
                        view,
                    )
                    recyclerView.layoutManager =
                        StaggeredGridLayoutManager(
                            Constants.SPAN_COUNT,
                            StaggeredGridLayoutManager.VERTICAL,
                        )
                    recyclerView.adapter = adapter
                }
            )
    }

    private fun createSearchRecycleAdapter(
        items: ArrayList<EvPointsEntity>,
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
            .actionSearchlistFragmentToSpotinfoFragment()
    }
}
