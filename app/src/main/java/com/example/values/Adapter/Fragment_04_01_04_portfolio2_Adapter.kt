package com.example.values.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.DTO.Picture_Data
import com.example.values.R

class Fragment_04_01_04_portfolio2_Adapter (private var datas:ArrayList<Picture_Data>,private val mContext: Context):
    RecyclerView.Adapter<Fragment_04_01_04_portfolio2_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_04_01_04_picture2_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])

            holder.itemView.setOnClickListener{

                val bundle = Bundle()
                bundle.putInt("picture_id", datas[position].picture_id)
                (mContext as MainActivity).navigateToFragment("fragment_01_01_ExhibitionDetail", bundle)

            }
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val pictureName2: TextView = itemView.findViewById(R.id.pf_picture_title)
            private val pictureView2: ImageView = itemView.findViewById(R.id.pictureView2)

            fun bind(item: Picture_Data) {
                pictureName2.text = item.picture_name
                pictureView2.setImageBitmap(BitmapFactory.decodeByteArray(item.picture_image,0,item.picture_image!!.size))

            }
        }



}