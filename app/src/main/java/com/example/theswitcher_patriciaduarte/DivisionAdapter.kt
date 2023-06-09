package com.example.theswitcher_patriciaduarte

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView

class DivisionAdapter(
    private val divisions: List<Division>,
    private val onItemClick: (Division) -> Unit
) : RecyclerView.Adapter<DivisionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_division, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val division = divisions[position]
        holder.nameTextView.text = division.name
        holder.lightSwitch.isChecked = division.isLightOn
        holder.lightSwitch.setOnCheckedChangeListener { _, isChecked ->
            division.isLightOn = isChecked
        }
        holder.itemView.setOnClickListener {
            onItemClick(division)
        }
    }

    override fun getItemCount(): Int {
        return divisions.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.division)
        val lightSwitch: SwitchCompat = itemView.findViewById(R.id.light_switch)
    }
}