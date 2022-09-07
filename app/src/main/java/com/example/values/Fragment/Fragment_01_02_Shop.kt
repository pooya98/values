package com.example.values.Fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_02_shop_goods_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio2_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio_Adapter
import com.example.values.DTO.Fragment_01_02_shop_goods_data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.DTO.Goods_Data
import com.example.values.R

class Fragment_01_02_Shop : Fragment() {



    private val goodsList = ArrayList<Fragment_01_02_shop_goods_data>()

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_01_02__shop, container, false)

        Log.d("Fragment_01_02_shop","TestTest")

        var recyclerView = view.findViewById<RecyclerView>(R.id.goodsRecycler)
        val goodsMainView = view.findViewById<ImageView>(R.id.goodsMainView)
        val titleView = view.findViewById<TextView>(R.id.goodsTitle)
        val goodsPrice = view.findViewById<TextView>(R.id.goodsPrice)
        val authorName= view.findViewById<TextView>(R.id.author_name)
        val authorName2 = view.findViewById<TextView>(R.id.author_name2)
        val authorProfile=view.findViewById<ImageView>(R.id.author_profile)



        val price = arguments?.getString("price")
        val author_id = arguments?.getInt("author_id")
        val title = arguments?.getString("title")
        val mainView = arguments?.getByteArray("mainview")


        val author = (activity as MainActivity).helper.selectUser(author_id!!)


        authorProfile.setImageBitmap(BitmapFactory.decodeByteArray(author.user_Image,0,author.user_Image!!.size))
        authorName.setText(author.user_name)
        authorName2.setText(author.user_name)

        goodsMainView.setImageBitmap(BitmapFactory.decodeByteArray(mainView,0,mainView!!.size))
        titleView.setText(title)
        goodsPrice.setText(price)

        fillList()

        val authorGoodsList = (activity as MainActivity).helper.selectGoodsByAuthor(author_id)

        val goodsAdapter = Fragment_01_02_shop_goods_Adapter(authorGoodsList,(activity as MainActivity))

        recyclerView?.adapter = goodsAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)




        return view
    }

    fun fillList(){


        goodsList.add(Fragment_01_02_shop_goods_data(1))
        goodsList.add(Fragment_01_02_shop_goods_data(2))


    }


    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("판매중인 굿즈")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("판매중인 굿즈")
    }
}