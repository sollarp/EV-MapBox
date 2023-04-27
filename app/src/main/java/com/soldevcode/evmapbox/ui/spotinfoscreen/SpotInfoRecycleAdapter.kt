package com.soldevcode.evmapbox.ui.spotinfoscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soldevcode.evmapbox.R
import com.soldevcode.evmapbox.data.remote.dto.Connections
import com.soldevcode.evmapbox.databinding.RowGridjcounterBinding

class SpotInfoRecycleAdapter(
    private val connectionsItemList: List<Connections>,
    private val usageCost: String?
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
        holder.binding.txtPointsCounter.text = String.format(
            holder.itemView.context.getString(R.string.points),
            connection.Quantity.toString()
        )
        holder.binding.txtPrice.text = String.format(
            holder.itemView.context.getString(R.string.txt_kW),
            connection.PowerKW.toString()
        )
        holder.binding.txtPrice.text = usageCost.toString().substringBefore("h")
        holder.binding.txtType.text = connection.ConnectionType.Title
        val ampVolt = "${connection.Amps}${holder.itemView.context.getString(R.string.amp)} " +
                "${connection.Voltage}${holder.itemView.context.getString(R.string.volt)}"
        holder.binding.txtAmpVolt.text = ampVolt
    }

    override fun getItemCount(): Int {
        return connectionsItemList.size
    }

}