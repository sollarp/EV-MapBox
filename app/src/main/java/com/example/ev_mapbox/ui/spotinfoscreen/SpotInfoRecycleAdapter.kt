package com.example.ev_mapbox.ui.spotinfoscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ev_mapbox.data.remote.dto.Connections
import com.example.ev_mapbox.databinding.FragmentSpotInfoBinding
import com.example.ev_mapbox.databinding.RowGridjcounterBinding

class SpotInfoRecycleAdapter(
    private val connectionsItemList: List<Connections>
) :
    RecyclerView.Adapter<SpotInfoRecycleAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: RowGridjcounterBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowGridjcounterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val connection = connectionsItemList[position]
        holder.binding.txtPointsCounter.text = connection.Quantity.toString()
        holder.binding.txtPrice.text = connection.PowerKW.toString()
        /*holder.binding.powerKW.text = connection.PowerKW.toString()
        holder.binding.voltage.text = connection.Voltage.toString()
        holder.binding.id.text = connection.ID.toString()
        holder.binding.levelId.text = connection.LevelID.toString()*/
    }

    override fun getItemCount(): Int {
        return connectionsItemList.size
    }

}