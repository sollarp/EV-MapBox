package com.example.call_mapbox_api.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.ui.searchscreen.SearchListFragment
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel
import com.example.call_mapbox_api.ui.searchscreen.SearchRecycleAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


fun hideKeyboard(view: View, context: Context) {
    val inputMethodManager =
        context.
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun showKeyboard(view: View, context: Context) {
    val inputMethodManager =
        context.
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(view , InputMethodManager.SHOW_FORCED)
}

/*fun navigateToDetailFragment(view: View, viewModel: ViewModel, itemDataConverter:
    (EvPointsEntity) -> ItemDataConverter): SearchRecycleAdapter {
    return SearchRecycleAdapter( object : SearchRecycleAdapter.OnAdapterListener {
        override fun onClick(address: EvPointsEntity) {
            viewModel.setDetailItems(itemDataConverter(address))
            val action = SearchListFragmentDirections.actionSearchlistFragmentToDetailFragment()
            view.findNavController().navigate(action)
        }
    })
}*/


fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
