package com.example.values.Adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.R

class Fragment_04_02_Adapter (private var datas:ArrayList<Fragment_04_02_Data>):
    RecyclerView.Adapter<Fragment_04_02_Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_04_02_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val eventTitle: TextView = itemView.findViewById(R.id.eventTitle)
            private val period: TextView = itemView.findViewById(R.id.period)
            private val views: TextView = itemView.findViewById(R.id.views)
            private val comments: TextView = itemView.findViewById(R.id.comments)


            fun bind(item: Fragment_04_02_Data) {
                eventTitle.text = item.eventTitle
                period.text = item.period
                views.text = item.views
                comments.text = item.comments


                itemView.setOnClickListener{
                        view->view.findNavController().navigate(R.id.action_fragment_04_02_to_fragment_04_02_QR)

                }


            }
        }



}