package com.example.call_mapbox_api.ui.homescreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.navigation.fragment.NavHostFragment
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.databinding.FragmentMapbarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapBarFragment : Fragment() {

    private var fragmentMapBarBinding: FragmentMapbarBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMapbarBinding.inflate(inflater, container, false)
        val view = binding.root
        fragmentMapBarBinding = binding
        val searchBar = view.findViewById<EditText>(R.id.input_search)
        searchBar.focusable = View.NOT_FOCUSABLE
        searchBar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val softKey =
                    context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                softKey.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                searchBar.focusable = View.FOCUSABLE
                val navHostFragment =
                    activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.searchlistFragment)
            }
        })
        return view
    }
}