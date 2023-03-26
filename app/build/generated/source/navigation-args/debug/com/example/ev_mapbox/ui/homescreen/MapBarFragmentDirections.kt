package com.example.ev_mapbox.ui.homescreen

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.ev_mapbox.MainNavDirections
import com.example.ev_mapbox.R

public class MapBarFragmentDirections private constructor() {
  public companion object {
    public fun actionMapBarFragmentToSearchlistFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mapBarFragment_to_searchlistFragment)

    public fun actionSplashFragmentToMapBarFragment(): NavDirections =
        MainNavDirections.actionSplashFragmentToMapBarFragment()
  }
}
