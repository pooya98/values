package com.example.values.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.R

class Fragment_04_01_04_portfolio2_Adapter (private var datas:ArrayList<Fragment_04_01_04_portfolio_Data>):
    RecyclerView.Adapter<Fragment_04_01_04_portfolio2_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_04_01_04_picture2_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val pictureName2: TextView = itemView.findViewById(R.id.pictureName2)


            fun bind(item: Fragment_04_01_04_portfolio_Data) {
                pictureName2.text = item.pictureName


            }
        }



}