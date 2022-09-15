package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_04_Adapter
import com.example.values.Adapter.Fragment_02_01_Cities_Adapter
import com.example.values.Adapter.Fragment_02_01_Space_Adapter
import com.example.values.DTO.Fragment_01_04_Data
import com.example.values.DTO.Fragment_02_01_Address_Data
import com.example.values.R

class Fragment_02_01_SpacePick : Fragment() {

    lateinit var fragment_02_01_CityAdapter: Fragment_02_01_Cities_Adapter
    lateinit var fragment_02_01_SpaceAdapter: Fragment_02_01_Space_Adapter

    lateinit var spaceRecycler : RecyclerView

    val datas = mutableListOf<String>()
    var datas_space = mutableListOf<Fragment_02_01_Address_Data>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__space_pick, container, false)
        // Inflate the layout for this fragment
        val recyclerview_city = view.findViewById<RecyclerView>(R.id.fragment_02_01_spacepick_city_list)
        val spaceRecycler = view.findViewById<RecyclerView>(R.id.fragment_02_01_spacepick_space_list)

        val selectButton = view.findViewById<Button>(R.id.fragment_02_01_Select_Button)


        spaceRecycler.layoutManager = LinearLayoutManager(activity)
        fragment_02_01_SpaceAdapter = Fragment_02_01_Space_Adapter(this)
        spaceRecycler.adapter = fragment_02_01_SpaceAdapter

        initRecycler_city(recyclerview_city)

        changeAddressList("경북")


        selectButton.setOnClickListener {

            if(fragment_02_01_SpaceAdapter.selectSpace!=null) {  //Null이 아닐시에만 선택완료버튼 처리.
                set_space_num(fragment_02_01_SpaceAdapter.selectSpace!!.space_id)
            }

            view.findNavController().navigateUp()
        }

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
            add("경북")
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
            add("경남")
            add("제주")

            fragment_02_01_CityAdapter.datas = datas
            fragment_02_01_CityAdapter.notifyDataSetChanged()

        }
    }

//    private fun initRecycler_space(rv_list: RecyclerView) {//datas:MutableList<String>
//        fragment_02_01_SpaceAdapter = Fragment_02_01_Space_Adapter(this)
//        rv_list.layoutManager = LinearLayoutManager(activity)
//        rv_list.adapter = fragment_02_01_SpaceAdapter
//
//
//        datas_space.apply {
//            add("VALUES경산 [A홀]")
//            add("VALUES경산 [B홀]")
//            add("VALUES경산 [C홀]")
//
//            fragment_02_01_SpaceAdapter.datas = datas_space
//            fragment_02_01_SpaceAdapter.notifyDataSetChanged()
//
//        }
//    }

    fun changeAddressList(region : String){

        val addressList : MutableList<Fragment_02_01_Address_Data> = (activity as MainActivity).helper.selectAddressByRegion(region)

        fragment_02_01_SpaceAdapter.datas = addressList
        fragment_02_01_SpaceAdapter.notifyDataSetChanged()
    }

    private fun set_space_num(space_id: Int) {
        val sharedPreference = context?.getSharedPreferences("space_pick", 0)
        val editor = sharedPreference?.edit()
        editor?.putString("space_id", space_id.toString())
        editor?.apply()
    }

}