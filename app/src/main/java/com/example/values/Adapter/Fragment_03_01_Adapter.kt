package com.example.values.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Fragment_03_01_Data
import com.example.values.R
import com.tbuonomo.viewpagerdotsindicator.setBackgroundCompat


class Fragment_03_01_Adapter (private var datas:ArrayList<Fragment_03_01_Data>):
    RecyclerView.Adapter<Fragment_03_01_Adapter.ViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_03_01_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])

        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val exhibitTitle: TextView = itemView.findViewById(R.id.exhibitTitle)
            private val reservDay: TextView = itemView.findViewById(R.id.reservDayText)
            private val exhibitPlace: TextView = itemView.findViewById(R.id.exhibitPlaceText)
            private val exhibitPayOrFree: TextView = itemView.findViewById(R.id.payORfreeText)
            private val dDay: TextView = itemView.findViewById(R.id.dDay)
            private val detailButton : Button = itemView.findViewById(R.id.detailButton)
            private val layout : ConstraintLayout = itemView.findViewById(R.id.reservLayout)


            fun bind(item: Fragment_03_01_Data) {
                exhibitTitle.text = item.exhibitTitle
                reservDay.text = item.reservDay
                exhibitPlace.text = item.exhibitPlace
                exhibitPayOrFree.text = item.exhibitPayOrFree
                dDay.text = item.dDay


                if(item.colorInfo=="purple"){
                    detailButton.setBackgroundResource(R.drawable.fragment_03_01_button_edge)
                    layout.setBackgroundResource(R.drawable.fragment_03_01_reserv_edge)

                }else if(item.colorInfo=="secondPurple"){
                    detailButton.setBackgroundResource(R.drawable.fragment_03_01_button_edge2)
                    layout.setBackgroundResource(R.drawable.fragment_03_01_reserv_edge2)
                }else{
                    detailButton.setBackgroundResource(R.drawable.fragment_03_01_button_edge3)
                    layout.setBackgroundResource(R.drawable.fragment_03_01_reserv_edge3)
                }





                detailButton.setOnClickListener{
                    view->view.findNavController().navigate(R.id.action_fragment_03_01_to_fragment_03_01_ticket)

                }
            }
        }



}