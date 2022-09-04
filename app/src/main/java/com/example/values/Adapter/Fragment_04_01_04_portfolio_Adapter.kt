package com.example.values.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.R

class Fragment_04_01_04_portfolio_Adapter (private var datas:ArrayList<Fragment_04_01_04_portfolio_Data>,private val mContext: Context):
    RecyclerView.Adapter<Fragment_04_01_04_portfolio_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_04_01_04_picture_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val pictureName: TextView = itemView.findViewById(R.id.pictureName)
            private val pictureView: ImageView  = itemView.findViewById(R.id.pictureView)


            fun bind(item: Fragment_04_01_04_portfolio_Data) {
                pictureName.text = item.pictureName

                pictureView.setOnClickListener{


                    (mContext as MainActivity).navigateToFragment("fragment_04_01_04_Portfolio_Detail")
                }
            }
        }



}