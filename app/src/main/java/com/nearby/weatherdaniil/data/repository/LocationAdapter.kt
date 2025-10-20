package com.nearby.weatherdaniil.data.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nearby.weatherdaniil.data.model.Location

class LocationAdapter(
    private val onClick: (Location) -> Unit
) : ListAdapter<Location, LocationAdapter.LocVH>(DIFF) {
    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Location>() {
            override fun areItemsTheSame(a: Location, b: Location) = a.id == b.id
            override fun areContentsTheSame(a: Location, b: Location) = a == b
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return LocVH(view)
    }

    override fun onBindViewHolder(holder: LocVH, position: Int) {
        val location = getItem(position)
        holder.bind(location)
    }

    inner class LocVH(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(location: Location) {
            (itemView as TextView).text =
                "${location.name}, ${location.country} (${location.latitude}, ${location.longitude},${location.temperature}, ${location.humidity})"
            itemView.setOnClickListener {
                onClick(location)
            }
        }
    }
}