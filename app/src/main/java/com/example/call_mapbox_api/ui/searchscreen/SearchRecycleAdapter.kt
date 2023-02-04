package com.example.call_mapbox_api.ui.searchscreen

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.data.local.EvPointsEntity
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val addressInfo = address[position].AddressInfo
        val items = "" +
                "${addressInfo.AddressLine1}, " +
                "${addressInfo.AddressLine2}, " +
                "${addressInfo.Town}, " +
                "${addressInfo.Postcode}"
        holder.binding.listView.text = items
        holder.binding.buttonGo.setOnClickListener {
            val navigationIntentUri =
                Uri.parse(
                    "google.navigation:q=" +
                            "${addressInfo.Latitude}," +
                            "${addressInfo.Longitude}"
                )
            val context = holder.itemView.context
            val intent = Intent(Intent.ACTION_VIEW, navigationIntentUri).apply {
                setPackage("com.google.android.apps.maps")
            }
            context.startActivity(intent)
        }
        holder.binding.listView.setOnClickListener { listener.onClick(address[position]) }
    }

    interface OnAdapterListener {
        fun onClick(address: EvPointsEntity)
    }

    override fun getItemCount() = address.size
}



