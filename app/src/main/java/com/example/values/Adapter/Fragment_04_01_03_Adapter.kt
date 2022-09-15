package com.example.values.Adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_04_01_03_Data
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.Fragment.Fragment_04_01_03
import com.example.values.Fragment.Fragment_04_01_03_Report
import com.example.values.R
import androidx.navigation.ui.navigateUp
import com.example.values.DTO.Exhibition_Data
import java.util.logging.Handler

class Fragment_04_01_03_Adapter (private var datas:ArrayList<Exhibition_Data>):
    RecyclerView.Adapter<Fragment_04_01_03_Adapter.ViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_04_01_03_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount() =  datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])

            holder.itemView.setOnClickListener{
                view-> view.findNavController().navigate(R.id.action_fragment_04_01_03_to_fragment_04_01_03_Report)


            }
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val exhibitTitle: TextView = itemView.findViewById(R.id.myExhibitTitle)
            private val exhibitPeriod: TextView = itemView.findViewById(R.id.exhibitPeriodTextView)
            private val exhibitPlace: TextView = itemView.findViewById(R.id.exhibitPlaceTextView)


            fun bind(item: Exhibition_Data) {
                exhibitTitle.text = "VALUES"+item.space_name+"점"
                exhibitPeriod.text = item.exhibition_startDate + " - "+item.exhibition_endDate
                exhibitPlace.text = "["+item.position_name+"]"



            }
        }



}