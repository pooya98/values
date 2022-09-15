package com.example.values.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter.POSITION_NONE
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Goods_Data
import com.example.values.DTO.Picture_Data
import com.example.values.R

class Fragment_01_01_picture_Adapter(picture_list: ArrayList<Picture_Data>, private val mContext: Context) : RecyclerView.Adapter<Fragment_01_01_picture_Adapter.PagerViewHolder>() {
    var item = picture_list

    var itemLIst: List<Picture_Data> = listOf(item.last()) + item + listOf(item.first())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = itemLIst.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        val helper = (mContext as MainActivity).helper
        val author  = helper.selectUser(itemLIst[position].author_id)


        holder.picture_image.setImageBitmap(BitmapFactory.decodeByteArray(itemLIst[position].picture_image,0,itemLIst[position].picture_image!!.size))
        holder.picture_image.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("picture_id", itemLIst[position].picture_id)
            (mContext as MainActivity).navigateToFragment("fragment_01_01_ExhibitionDetail", bundle)
        }

        holder.picture_name.setText("'"+itemLIst[position].picture_name+"'")
        holder.author_name.setText("'"+itemLIst[position].author_name+"'")
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.fragment_01_01_picture_item, parent, false)){

        val picture_image  = itemView.findViewById<ImageView>(R.id.fragment_01_01_picture_image)!!
        val picture_name = itemView.findViewById<TextView>(R.id.fragment_01_01_picture_name)!!
        val author_name = itemView.findViewById<TextView>(R.id.fragment_01_01_author_name)!!
    }
}