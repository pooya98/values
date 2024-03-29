package com.example.values.Adapter

import android.R
import android.content.Context
import android.net.Uri

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Fragment_02_01_Post_Adapter internal constructor(list: ArrayList<Uri>?, context: Context?) :
    RecyclerView.Adapter<Fragment_02_01_Post_Adapter.ViewHolder>() {
    private var mData: ArrayList<Uri>? = null
    private var mContext: Context? = null

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            // 뷰 객체에 대한 참조.
            image = itemView.findViewById(com.example.values.R.id.image_11)
        }
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    // LayoutInflater - XML에 정의된 Resource(자원) 들을 View의 형태로 반환.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context: Context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(com.example.values.R.layout.fragment_02_01_post_item,parent,false)
        return ViewHolder(view)
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image_uri: Uri = mData!![position]
        Glide.with(mContext!!)
            .load(image_uri)
            .into(holder.image)
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    override fun getItemCount(): Int {
        return mData!!.size
    }

    // 생성자에서 데이터 리스트 객체, Context를 전달받음.
    init {
        mData = list
        mContext = context
    }
}