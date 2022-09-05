package com.example.values.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_01_02_shop_goods_data
import com.example.values.R

class Fragment_01_02_shop_goods_Adapter (private var datas:ArrayList<Fragment_01_02_shop_goods_data>, private val mContext: Context):
    RecyclerView.Adapter<Fragment_01_02_shop_goods_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_01_02_shop_goods_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {



            private val goodsImage: ImageView  = itemView.findViewById(R.id.goodsView)


            fun bind(item: Fragment_01_02_shop_goods_data) {

                if(item.count==1) {
                    goodsImage.setImageResource(R.drawable.goods_1)
                }else{
                    goodsImage.setImageResource(R.drawable.goods_2)
                }

            }
        }



}