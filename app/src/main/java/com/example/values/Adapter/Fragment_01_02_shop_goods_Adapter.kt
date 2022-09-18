package com.example.values.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Fragment_01_02_shop_goods_data
import com.example.values.DTO.Goods_Data
import com.example.values.R

class Fragment_01_02_shop_goods_Adapter (private var datas:ArrayList<Goods_Data>, private val mContext: Context):
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


            fun bind(item: Goods_Data) {
               goodsImage.setImageBitmap(BitmapFactory.decodeByteArray(item.goods_image,0,item.goods_image!!.size))

                goodsImage.setOnClickListener{


                    (mContext as MainActivity).navigateToFragment("fragment_01_02_Shop", item)
                }


            }
        }



}