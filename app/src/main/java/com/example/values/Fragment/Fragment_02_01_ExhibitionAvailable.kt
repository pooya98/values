package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Adapter.Fragment_02_01_Available_Adapter
import com.example.values.Adapter.Fragment_02_01_Cities_Adapter
import com.example.values.Adapter.Fragment_02_01_Space_Adapter
import com.example.values.R

class Fragment_02_01_ExhibitionAvailable : Fragment() {

    lateinit var fragment_02_01_Available_Adapter: Fragment_02_01_Available_Adapter

    val datas = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__exhibition_available, container, false)
        // Inflate the layout for this fragment

        val recyclerview_available = view.findViewById<RecyclerView>(R.id.fragment_02_01_ExhibitionAvailable_list)

        initRecycler_available(recyclerview_available)

        return view
    }

    private fun initRecycler_available(rv_list: RecyclerView) {
        fragment_02_01_Available_Adapter = Fragment_02_01_Available_Adapter(this)
        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = fragment_02_01_Available_Adapter


        datas.apply {
            add("6/15 - 7/15 중 자유롭게 (최대 7일)")
            add("6/20 - 6/23 중 자유롭게")
            add("6/22 - 6/23 중 자유롭게")

            fragment_02_01_Available_Adapter.datas = datas
            fragment_02_01_Available_Adapter.notifyDataSetChanged()

        }
    }

}