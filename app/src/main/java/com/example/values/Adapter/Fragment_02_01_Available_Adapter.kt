package com.example.values.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Exhibition_Data
import com.example.values.Fragment.Fragment_02
import com.example.values.Fragment.Fragment_02_01_ExhibitionAvailable
import com.example.values.Fragment.Fragment_02_01_SpacePick
import com.example.values.R
import org.w3c.dom.Text

class Fragment_02_01_Available_Adapter(private val context: Fragment_02_01_ExhibitionAvailable) : RecyclerView.Adapter<Fragment_02_01_Available_Adapter.ViewHolder>(){
    var datas = mutableListOf<Exhibition_Data>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_02_01_available_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val available_name: TextView = itemView.findViewById(R.id.available_name)
        private val start_date:TextView = itemView.findViewById(R.id.startDateText)
        private val end_date:TextView = itemView.findViewById(R.id.endDateText)
        private val position_brand:TextView = itemView.findViewById(R.id.positionBrandText)


        fun bind(item: Exhibition_Data) {
            available_name.text = "VALUES"+item.space_name
            start_date.text =item.exhibition_startDate
            end_date.text = item.exhibition_endDate
            position_brand.text = item.position_name+" - "+"["+item.exhibition_type+"]"

            val bundle = Bundle()
            bundle.putInt("exhibition_id", item.exhibition_id)


            itemView.setOnClickListener {

                view->view.findNavController().navigate(R.id.action_fragment_02_01_ExhibitionAvailable_to_fragment_02_01_Post, bundle)
            }
        }
    }
}