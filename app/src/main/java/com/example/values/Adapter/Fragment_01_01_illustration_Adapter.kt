package com.example.values.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.R

class Fragment_01_01_illustration_Adapter(illustration_list: ArrayList<Int>) : RecyclerView.Adapter<Fragment_01_01_illustration_Adapter.PagerViewHolder>() {
    var item = illustration_list

    var itemLIst: List<Int> = listOf(item.last()) + item + listOf(item.first())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = itemLIst.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.illustration_image.setImageResource(itemLIst[position])
        holder.illustration_text.setText("ITEM")
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.fragment_01_01_illustration_item, parent, false)){

        val illustration_image  = itemView.findViewById<ImageView>(R.id.fragment_01_01_illustration_image)!!
        val illustration_text = itemView.findViewById<TextView>(R.id.fragment_01_01_illustration_text)!!
    }
}