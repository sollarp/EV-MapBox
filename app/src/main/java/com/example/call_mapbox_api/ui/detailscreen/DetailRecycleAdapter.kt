package com.example.call_mapbox_api.ui.detailscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.data.remote.Connections


class DetailRecycleAdapter(private val connectionsItemList: List<Connections>):
    RecyclerView.Adapter<DetailRecycleAdapter.MainViewHolder>(){

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val powerKW: TextView
        val voltage: TextView
        val id: TextView
        val levelId: TextView

        init {
            // Define click listener for the ViewHolder's View.
            powerKW = itemView.findViewById(R.id.power_KW)
            voltage = itemView.findViewById(R.id.voltage)
            id = itemView.findViewById(R.id.id)
            levelId = itemView.findViewById(R.id.level_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_connections, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.powerKW.text = connectionsItemList.map { it.PowerKW }[position].toString()
        holder.voltage.text = connectionsItemList.map { it.Voltage }[position].toString()
        holder.id.text = connectionsItemList.map { it.ID }[position].toString()
        holder.levelId.text = connectionsItemList.map { it.LevelID }[position].toString()
    }

    override fun getItemCount(): Int {
        return connectionsItemList.size
    }

}