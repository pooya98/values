package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_02_shop_goods_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio2_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio_Adapter
import com.example.values.DTO.Fragment_01_02_shop_goods_data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.R

class Fragment_01_02_Shop : Fragment() {
    private val goodsList = ArrayList<Fragment_01_02_shop_goods_data>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var recyclerView = view?.findViewById<RecyclerView>(R.id.goodsRecycler)

        fillList()

        val goodsAdapter = Fragment_01_02_shop_goods_Adapter(goodsList,(activity as MainActivity))

        recyclerView?.adapter = goodsAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_01_02__shop, container, false)
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