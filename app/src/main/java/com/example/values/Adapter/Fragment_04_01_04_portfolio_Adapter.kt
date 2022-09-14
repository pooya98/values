package com.example.values.Adapter

import android.content.Context
import android.graphics.BitmapFactory
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
import com.example.values.DTO.Goods_Data
import com.example.values.R

class Fragment_04_01_04_portfolio_Adapter (private var datas : ArrayList<Goods_Data>, private val mContext: Context):
    RecyclerView.Adapter<Fragment_04_01_04_portfolio_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio_goods,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val goodsView: ImageView  = itemView.findViewById(R.id.portfolio_goodsView)


            fun bind(item: Goods_Data) {
                goodsView.setImageBitmap(BitmapFactory.decodeByteArray(item.goods_image,0,item.goods_image!!.size))
                goodsView.setOnClickListener{


                    (mContext as MainActivity).navigateToFragment("fragment_04_01_04_Portfolio_Detail")
                }
            }
        }



}