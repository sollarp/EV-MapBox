package com.example.ev_mapbox.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.example.ev_mapbox.R

class CustomInfoWindowAdapter(private val context: Context) : GoogleMap.InfoWindowAdapter {

    private val view = LayoutInflater.from(context).inflate(R.layout.item_popupcardview, null)

    override fun getInfoContents(p0: Marker): View? {
        // Return null to use the default info window.
        return null
    }

    override fun getInfoWindow(p0: Marker): View? {
      /*  // Set the marker title and snippet as the text in the card view.
        val titleTextView = view.findViewById<TextView>(R.id.title_text_view)
        val snippetTextView = view.findViewById<TextView>(R.id.snippet_text_view)
        titleTextView.text = marker?.title
        snippetTextView.text = marker?.snippet*/

        // Return the card view as the info window.
        return view
    }
}