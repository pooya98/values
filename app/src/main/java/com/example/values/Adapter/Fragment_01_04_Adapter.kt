package com.example.values.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_01_04_Data
import com.example.values.Fragment.Fragment_01_04
import com.example.values.R

class Fragment_01_04_Adapter(private val context: Fragment_01_04) : RecyclerView.Adapter<Fragment_01_04_Adapter.ViewHolder>() {

    var datas = mutableListOf<Fragment_01_04_Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_01_04_contents_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = itemView.findViewById(R.id.fragment_01_04_item_title)
        private val description: TextView = itemView.findViewById(R.id.fragment_01_04_item_description)

        fun bind(item: Fragment_01_04_Data) {
            title.text = item.title
            description.text = item.description
        }
    }


}