package com.example.values.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Fragment.Fragment_02_01_SpacePick
import com.example.values.R

class Fragment_02_01_Space_Adapter(private val context: Fragment_02_01_SpacePick) : RecyclerView.Adapter<Fragment_02_01_Space_Adapter.ViewHolder>(){
    var datas = mutableListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_02_01_space_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val space_name: TextView = itemView.findViewById(R.id.space_name)
        private val space_address: TextView = itemView.findViewById(R.id.space_address)

        fun bind(item: String) {
            space_name.text = item
            space_address.text = item
        }
    }
}