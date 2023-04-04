package com.example.ev_mapbox.ui.searchscreen

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.ev_mapbox.MainNavDirections
import com.example.ev_mapbox.R

public class SearchListFragmentDirections private constructor() {
  public companion object {
    public fun actionSearchlistFragmentToSpotinfoFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_searchlistFragment_to_spotinfoFragment)

    public fun actionSplashFragmentToMapBarFragment(): NavDirections =
        MainNavDirections.actionSplashFragmentToMapBarFragment()
  }
}
