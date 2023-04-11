package com.example.ev_mapbox.ui.searchscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ev_mapbox.R
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.databinding.ItemCardviewBinding
import com.example.ev_mapbox.util.getNavigationIntent
import com.google.android.gms.maps.model.LatLng

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
        val latLng = evPoint.AddressInfo.Latitude?.let {
            evPoint.AddressInfo.Longitude?.let { it1 ->
                LatLng(
                    it,
                    it1
                )
            }
        }
        holder.binding.btnCard.setOnClickListener {
            val intent = getNavigationIntent(latLng)
            holder.itemView.context.startActivity(intent)
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
            val title = selectedLocation.AddressInfo.Title
            binding.txtCardAddress.text = address
            binding.txtCardPointsCounter.text = String.format(
                itemView.context.getString(R.string.points),
                selectedLocation.NumberOfPoints.toString()
            )
            binding.txtCardTitle.text = title
        }

    }
}


