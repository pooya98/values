package com.example.values.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_01_04_Data
import com.example.values.Fragment.Fragment_01_04
import com.example.values.Fragment.Fragment_02_01
import com.example.values.Fragment.Fragment_02_01_SpacePick
import com.example.values.R

class Fragment_02_01_Cities_Adapter(private val context: Fragment_02_01_SpacePick) : RecyclerView.Adapter<Fragment_02_01_Cities_Adapter.ViewHolder>(){
    var datas = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_02_01_city_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val city_name: TextView = itemView.findViewById(R.id.TextView_city_name)

        fun bind(item: String) {
            city_name.text = item
        }
    }
}