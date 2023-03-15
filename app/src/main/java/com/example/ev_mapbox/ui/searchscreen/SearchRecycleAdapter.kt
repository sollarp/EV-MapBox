package com.example.ev_mapbox.ui.searchscreen

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.data.remote.dto.AddressInfo
import com.example.ev_mapbox.databinding.ItemCardviewBinding

class SearchRecycleAdapter(
    private val evPointsEntity: ArrayList<EvPointsEntity>,
    private val listener: OnAdapterListener
) :
    RecyclerView.Adapter<SearchRecycleAdapter.ViewHolder>() {

    fun updateOrders( newEvPointsEntity: List<EvPointsEntity>) {
        evPointsEntity.clear()
        evPointsEntity.addAll(newEvPointsEntity)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val evPoint = evPointsEntity[position]
        holder.bind(evPoint)
        holder.binding.btnCard.setOnClickListener {
            val navigation = holder.navigationIntentUri(evPoint.AddressInfo)
            val context = holder.itemView.context
            val intent = Intent(Intent.ACTION_VIEW, navigation).apply {
                setPackage("com.google.android.apps.maps")
            }
            context.startActivity(intent)
        }
        holder.binding.itemCardViewLinear.setOnClickListener { listener.onClick(evPointsEntity[position]) }
    }

    interface OnAdapterListener {
        fun onClick(address: EvPointsEntity)
    }

    override fun getItemCount() = evPointsEntity.size

    inner class ViewHolder(val binding: ItemCardviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(selectedLocation: EvPointsEntity) {
            val address = "${selectedLocation.AddressInfo.AddressLine1}, " +
                    "${selectedLocation.AddressInfo.Town}, " +
                    "${selectedLocation.AddressInfo.Postcode}"
            val pointsCount = selectedLocation.NumberOfPoints
            val title = selectedLocation.AddressInfo.Title
            binding.txtCardAddress .text = address
            binding.txtCardPointsCounter.text = pointsCount.toString()
            binding.txtCardTitle.text = title
        }

        fun navigationIntentUri(addressInfo: AddressInfo): Uri =
            Uri.parse(
                "google.navigation:q=" +
                        "${addressInfo.Latitude}," +
                        "${addressInfo.Longitude}"
            )
    }
}


