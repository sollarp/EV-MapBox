package com.example.call_mapbox_api.ui.searchscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.model.EvPointDetails

class SearchRecycleAdapter(
    private val address: List<EvPointDetails>,
    private val listener: OnAdapterListener
) :
    RecyclerView.Adapter<SearchRecycleAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView
        val goButton: Button = view.findViewById(R.id.button_go)

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.list_view)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater
            .inflate(R.layout.fragment_searchlistitem, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val items = address.map {
            it.AddressInfo.AddressLine1 + ", " +
                    it.AddressInfo.AddressLine2 + ", " +
                    it.AddressInfo.Town + ", " +
                    it.AddressInfo.Postcode
        }
        viewHolder.textView.text = items[position]
        viewHolder.goButton.setOnClickListener {
            val lat = address.map { (it.AddressInfo.Latitude) }[position]
            val lon = address.map { it.AddressInfo.Longitude }[position]
            val navigationIntentUri: Uri =
                Uri.parse("google.navigation:q=$lat,$lon")
            val context = viewHolder.itemView.context
            val bundle = Bundle()
            val intent = Intent(Intent.ACTION_VIEW, navigationIntentUri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(context, intent, bundle)
        }
        val pos = address[position]
        viewHolder.textView.setOnClickListener { listener.onClick(pos) }
    }

    interface OnAdapterListener {
        fun onClick(address: EvPointDetails)
    }

    override fun getItemCount() = address.size
}



