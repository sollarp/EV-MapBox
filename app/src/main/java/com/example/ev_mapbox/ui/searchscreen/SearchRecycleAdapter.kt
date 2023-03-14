package com.example.ev_mapbox.ui.searchscreen

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.data.remote.dto.AddressInfo
import com.example.ev_mapbox.databinding.FragmentSearchlistitemBinding

class SearchRecycleAdapter(
    private val address: ArrayList<EvPointsEntity>,
    private val listener: OnAdapterListener
) :
    RecyclerView.Adapter<SearchRecycleAdapter.ViewHolder>() {

    fun updateOrders( newEvPointsEntity: List<EvPointsEntity>) {
        address.clear()
        address.addAll(newEvPointsEntity)
        notifyDataSetChanged()
    }

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
        holder.bind(addressInfo)
        holder.binding.buttonGo.setOnClickListener {
            val navigation = holder.navigationIntentUri(addressInfo)
            val context = holder.itemView.context
            val intent = Intent(Intent.ACTION_VIEW, navigation).apply {
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

    inner class ViewHolder(val binding: FragmentSearchlistitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(addressInfo: AddressInfo): String {
            val items = "${addressInfo.AddressLine1}, " +
                    "${addressInfo.AddressLine2}, " +
                    "${addressInfo.Town}, " +
                    "${addressInfo.Postcode}"
            binding.listView.text = items
            return items
        }

        fun navigationIntentUri(addressInfo: AddressInfo): Uri =
            Uri.parse(
                "google.navigation:q=" +
                        "${addressInfo.Latitude}," +
                        "${addressInfo.Longitude}"
            )

    }

}


