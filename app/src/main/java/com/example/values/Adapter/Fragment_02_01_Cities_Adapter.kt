package com.example.values.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Fragment_01_04_Data
import com.example.values.Fragment.Fragment_01_04
import com.example.values.Fragment.Fragment_02_01
import com.example.values.Fragment.Fragment_02_01_SpacePick
import com.example.values.R

class Fragment_02_01_Cities_Adapter(private val context: Fragment_02_01_SpacePick) : RecyclerView.Adapter<Fragment_02_01_Cities_Adapter.ViewHolder>(){
    var datas = mutableListOf<String>()

    var selectPos = -1 //클릭 효과를 위해서 저장할 position


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_02_01_city_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

        if(selectPos == position){

            holder.itemView.setBackgroundColor(Color.parseColor("#7600FF"))
            holder.itemView.findViewById<TextView>(R.id.TextView_city_name).setTextColor(Color.WHITE)

        }else{
            holder.itemView.setBackgroundColor((Color.parseColor("#00FFFFFF")))
            holder.itemView.findViewById<TextView>(R.id.TextView_city_name).setTextColor(Color.parseColor("#8A8A8A"))//dh_gray

        }


        holder.itemView.setOnClickListener{

            var beforePos = selectPos
            selectPos = position

            context.changeAddressList(datas[position])

            notifyItemChanged(beforePos)
            notifyItemChanged(selectPos)


        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val city_name: TextView = itemView.findViewById(R.id.TextView_city_name)

        fun bind(item: String) {
            city_name.text = item



        }
    }
}