package com.example.call_mapbox_api


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.model.EvPointDetails


open class MainAdapter(private val openMapList: ArrayList<EvPointDetails>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = itemView.findViewById(R.id.id_name)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_list_id, viewGroup, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(mainViewHolder: MainViewHolder, position: Int) {
        mainViewHolder.textView.text = openMapList.map { it.ID }[position].toString()
        mainViewHolder.textView.setOnClickListener {
            val intent = Intent(mainViewHolder.itemView.context, SecondActivity::class.java)
            val pos = openMapList[position]
            println("open maplist VALUE: $openMapList")
            //intent.putExtra("SELECTED ITEM POSITION", position)
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
            mainViewHolder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return openMapList.size
    }


}