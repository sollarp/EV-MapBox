package com.example.call_mapbox_api.ui.searchscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.databinding.FragmentSearchlistitemBinding

class SearchRecycleAdapter(
    private val address: List<EvPointsEntity>,
    private val listener: OnAdapterListener
) :
    RecyclerView.Adapter<SearchRecycleAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(
        val binding: FragmentSearchlistitemBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentSearchlistitemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = address.map {
            it.AddressInfo.AddressLine1 + ", " +
                    it.AddressInfo.AddressLine2 + ", " +
                    it.AddressInfo.Town + ", " +
                    it.AddressInfo.Postcode
        }
        holder.binding.listView.text = items[position]
        holder.binding.buttonGo.setOnClickListener {
            val lat = address.map { (it.AddressInfo.Latitude) }[position]
            val lon = address.map { it.AddressInfo.Longitude }[position]
            val navigationIntentUri: Uri =
                Uri.parse("google.navigation:q=$lat,$lon")
            val context = holder.itemView.context
            val bundle = Bundle()
            val intent = Intent(Intent.ACTION_VIEW, navigationIntentUri)
            intent.setPackage("com.google.android.apps.maps")
            // not recommended to call this here
            startActivity(context, intent, bundle)
        }
        val pos = address[position]
        holder.binding.listView.setOnClickListener { listener.onClick(pos) }
    }

    interface OnAdapterListener {
        fun onClick(address: EvPointsEntity)
    }

    override fun getItemCount() = address.size
}



