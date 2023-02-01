package com.example.call_mapbox_api.ui.detailscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.data.remote.Connections
import com.example.call_mapbox_api.databinding.FragmentListConnectionsBinding

class DetailRecycleAdapter(
    private val connectionsItemList: List<Connections>
) :
    RecyclerView.Adapter<DetailRecycleAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: FragmentListConnectionsBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentListConnectionsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.powerKW.text = connectionsItemList.map { it.PowerKW }[position].toString()
        holder.binding.voltage.text = connectionsItemList.map { it.Voltage }[position].toString()
        holder.binding.id.text = connectionsItemList.map { it.ID }[position].toString()
        holder.binding.levelId.text = connectionsItemList.map { it.LevelID }[position].toString()
    }

    override fun getItemCount(): Int {
        return connectionsItemList.size
    }

}