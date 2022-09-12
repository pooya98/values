package com.example.values.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter.POSITION_NONE
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Goods_Data
import com.example.values.R

class Fragment_01_02_goods_Adapter(brading_list: ArrayList<Goods_Data>, private val mContext: Context) : RecyclerView.Adapter<Fragment_01_02_goods_Adapter.PagerViewHolder>() {
    var item = brading_list

    var itemLIst: List<Goods_Data> = listOf(item.last()) + item + listOf(item.first())


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))



    override fun getItemCount(): Int = itemLIst.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        val helper = (mContext as MainActivity).helper
        val author  = helper.selectUser(itemLIst[position].author_id)

        val sender : Goods_Data = itemLIst[position]

        holder.branding_text.setText("'"+itemLIst[position].goods_name+"'")
        holder.branding_author.setText("'"+author.user_name+"'")
        holder.branding_image.setImageBitmap(BitmapFactory.decodeByteArray(itemLIst[position].goods_image,0,itemLIst[position].goods_image!!.size))
        holder.branding_image.setOnClickListener {
            (mContext as MainActivity).navigateToFragment("fragment_01_02_Shop",sender)
        }
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.fragment_01_02_branding_item, parent, false)){

        val branding_image  = itemView.findViewById<ImageView>(R.id.fragment_01_02_branding_image)!!
        val branding_text = itemView.findViewById<TextView>(R.id.fragment_01_02_branding_text)!!
        val branding_author = itemView.findViewById<TextView>(R.id.fragment_01_02_goodsAuthor)!!



    }
}