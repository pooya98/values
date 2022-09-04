package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_04_Adapter
import com.example.values.Adapter.Fragment_02_01_Cities_Adapter
import com.example.values.Adapter.Fragment_02_01_Space_Adapter
import com.example.values.DTO.Fragment_01_04_Data
import com.example.values.R

class Fragment_02_01_SpacePick : Fragment() {

    lateinit var fragment_02_01_CityAdapter: Fragment_02_01_Cities_Adapter
    lateinit var fragment_02_01_SpaceAdapter: Fragment_02_01_Space_Adapter

    val datas = mutableListOf<String>()
    val datas_space = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__space_pick, container, false)
        // Inflate the layout for this fragment
        val recyclerview_city = view.findViewById<RecyclerView>(R.id.fragment_02_01_spacepick_city_list)
        val recyclerview_space = view.findViewById<RecyclerView>(R.id.fragment_02_01_spacepick_space_list)

        initRecycler_city(recyclerview_city)
        initRecycler_space(recyclerview_space)

        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("전시공간 선택")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("전시공간 선택")
    }

    private fun initRecycler_city(rv_list: RecyclerView) {
        fragment_02_01_CityAdapter = Fragment_02_01_Cities_Adapter(this)
        rv_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_list.adapter = fragment_02_01_CityAdapter


        datas.apply {
            add("서울")
            add("세종")
            add("인천")
            add("대전")
            add("광주")
            add("대구")
            add("울산")
            add("부산")
            add("경기")
            add("강원")
            add("충북")
            add("충남")
            add("전북")
            add("전남")
            add("경북")
            add("경남")
            add("제주")

            fragment_02_01_CityAdapter.datas = datas
            fragment_02_01_CityAdapter.notifyDataSetChanged()

        }
    }

    private fun initRecycler_space(rv_list: RecyclerView) {
        fragment_02_01_SpaceAdapter = Fragment_02_01_Space_Adapter(this)
        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = fragment_02_01_SpaceAdapter


        datas_space.apply {
            add("VALUES경산 [A홀]")
            add("VALUES경산 [B홀]")
            add("VALUES경산 [C홀]")

            fragment_02_01_SpaceAdapter.datas = datas_space
            fragment_02_01_SpaceAdapter.notifyDataSetChanged()

        }
    }

}