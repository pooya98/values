package com.example.values.Adapter

import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.values.DTO.Fragment_02_01_Address_Data
import com.example.values.Fragment.Fragment_02_01_SpacePick
import com.example.values.R

class Fragment_02_01_Space_Adapter(private val context: Fragment_02_01_SpacePick) : RecyclerView.Adapter<Fragment_02_01_Space_Adapter.ViewHolder>(){
    var datas = mutableListOf<Fragment_02_01_Address_Data>()

    var selectPos = -1 //클릭 효과를 위해서 저장할 position
    var selectSpace : Fragment_02_01_Address_Data? = null  //클릭 되어있는 position의 space 객체를 전달하기 위해 저장.
    var button : Button? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_02_01_space_item, parent,false)
        button = parent.findViewById<Button>(R.id.fragment_02_01_Select_Button)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
        if(selectPos == position){
            holder.itemView.setBackgroundColor((Color.parseColor("#aaaaaa")))

            button?.isEnabled = true
            Log.d("TESTTEST", button?.isEnabled.toString())

        }else{
            holder.itemView.setBackgroundColor((Color.WHITE))
        }

        holder.itemView.setOnClickListener{

            var beforePos = selectPos
            selectPos = position

            selectSpace = datas[position]

            notifyItemChanged(beforePos)
            notifyItemChanged(selectPos)

        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val space_name: TextView = itemView.findViewById(R.id.space_name)
        private val space_image : ImageView = itemView.findViewById<ImageView>(R.id.space_imageView)

        fun bind(item: Fragment_02_01_Address_Data) {
            space_name.text = "VALUES "+item.address
            space_image.setImageBitmap(BitmapFactory.decodeByteArray(item.addressImage,0,item.addressImage!!.size))
        }
    }
}