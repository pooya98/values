package com.example.values.Adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.R

class Fragment_04_01_02_badges_Adapter (private var datas:ArrayList<Fragment_04_01_02_badges_Data>):
    RecyclerView.Adapter<Fragment_04_01_02_badges_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_04_01_02_badges_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val badgeName: TextView = itemView.findViewById(R.id.badgesTextView)
            private val badgeImage : ImageView = itemView.findViewById<ImageView>(R.id.badgesImageView)


            fun bind(item: Fragment_04_01_02_badges_Data) {
                badgeName.text = item.badgeName
                var num : Int = item.badgeNum

               when(num){
                   1->{badgeImage.setImageResource(R.drawable.badges04_01_02_1)
                       badgeImage.scaleType = ImageView.ScaleType.CENTER_CROP
                       badgeName.setTextColor(Color.parseColor("#7600FF"))
                   }

                   2->{badgeImage.setImageResource(R.drawable.badges04_01_02_2)
                       badgeImage.scaleType = ImageView.ScaleType.CENTER_CROP
                       badgeName.setTextColor(Color.parseColor("#7600FF"))
                   }

                   3->badgeImage.setImageResource(R.drawable.badges04_01_02_3)
                   4->badgeImage.setImageResource(R.drawable.badges04_01_02_4)
                   5->badgeImage.setImageResource(R.drawable.badges04_01_02_5)
                   6->badgeImage.setImageResource(R.drawable.badges04_01_02_6)
                   7->badgeImage.setImageResource(R.drawable.badges04_01_02_7)
                   8->badgeImage.setImageResource(R.drawable.badges04_01_02_8)
                   9->badgeImage.setImageResource(R.drawable.badges04_01_02_9)
                   10->badgeImage.setImageResource(R.drawable.badges04_01_02_10)
                   11->badgeImage.setImageResource(R.drawable.badges04_01_02_11)
                   12->badgeImage.setImageResource(R.drawable.badges04_01_02_12)
                   else -> println("null")



               }




            }
        }



}