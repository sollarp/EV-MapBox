package com.example.call_mapbox_api.homescreen.data

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
import com.example.call_mapbox_api.Connection
import com.example.call_mapbox_api.util.ItemDataConverter
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.toConnections
import com.example.call_mapbox_api.homescreen.ui.DetailActivity

class SearchRecycleAdapter(private val address: List<EvPointDetails>) :
    RecyclerView.Adapter<SearchRecycleAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView
        val goButton = view.findViewById<Button>(R.id.button_go)

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.list_view)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater
            .inflate(R.layout.fragment_searchlist, viewGroup, false)
        return ViewHolder(view)
    }
    @SuppressLint("QueryPermissionsNeeded")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val items = address.map {
            it.AddressInfo?.AddressLine1 + ", " +
                    it.AddressInfo?.AddressLine2 + ", " +
                    it.AddressInfo?.Town + ", " +
                    it.AddressInfo?.Postcode
        }
        viewHolder.textView.text = items[position].toString()
        viewHolder.goButton.setOnClickListener {
            val lat = address.map { (it.AddressInfo?.Latitude)}[position]
            val lon = address.map { it.AddressInfo?.Longitude}[position]
            val navigationIntentUri: Uri =
                Uri.parse("google.navigation:q=" + lat + "," + lon)
            val context = viewHolder.itemView.context
            val bundle = Bundle()
            val intent = Intent(Intent.ACTION_VIEW, navigationIntentUri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(context, intent, bundle)
        }
        viewHolder.textView.setOnClickListener {
            val intent = Intent(viewHolder.itemView.context, DetailActivity::class.java)
            val pos = address[position]
            val AddressLine1 = pos.AddressInfo?.AddressLine1
            val AddressLine2 = pos.AddressInfo?.AddressLine2
            val Longitude = pos.AddressInfo?.Longitude
            val Latitude = pos.AddressInfo?.Latitude
            val Title = pos.AddressInfo?.Title
            val PostCode = pos.AddressInfo?.Postcode
            val Town = pos.AddressInfo?.Town
            val UsageCost = pos.UsageCost
            val NumberOfPoints = pos.NumberOfPoints
            val dataUpdate = pos.DateLastStatusUpdate
            val connectionList = pos.Connection

            val selectedPoint = ItemDataConverter(
                AddressLine1,
                AddressLine2,
                Longitude,
                Latitude,
                Title,
                PostCode,
                Town,
                UsageCost,
                NumberOfPoints,
                dataUpdate,
            )
            val connToArray = connectionList?.toConnections()
            intent.putExtra("ALL ITEMS", selectedPoint)
            val arrayHolder = connToArray?.let { it1 -> ArrayList<Connection>(it1) }
            intent.putParcelableArrayListExtra("ARRAY OF CONNECTIONS", arrayHolder)
            viewHolder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount() = address.size
}

