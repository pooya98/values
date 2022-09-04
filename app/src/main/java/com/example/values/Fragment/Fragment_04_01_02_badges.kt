package com.example.values.Fragment

import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Adapter.Fragment_04_01_02_badges_Adapter
import com.example.values.Adapter.Fragment_04_02_Adapter
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.R
import com.example.values.databinding.Fragment040102BadgesBinding


class Fragment_04_01_02_badges : Fragment() ,View.OnClickListener{


    lateinit var recyclerView : RecyclerView
    private val badgesList = ArrayList<Fragment_04_01_02_badges_Data>()

    private var mBinding : Fragment040102BadgesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040102BadgesBinding.inflate(inflater, container,false)

        mBinding = binding




        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view?.findViewById(R.id.badgesRecyclerView)!!

        fillList()
        val badgesAdapter = Fragment_04_01_02_badges_Adapter(badgesList)
        recyclerView.adapter = badgesAdapter
        recyclerView.layoutManager = GridLayoutManager(activity,3)





    }

    override fun onClick(v: View?) {

        when(v?.id){

        }
    }

    fun fillList(){

        badgesList.add(Fragment_04_01_02_badges_Data("'유명세의 시작'",1))
        badgesList.add(Fragment_04_01_02_badges_Data("'리뷰의 왕'",2))
        badgesList.add(Fragment_04_01_02_badges_Data("'베스트 작가'",3))
        badgesList.add(Fragment_04_01_02_badges_Data("'의뢰자'",4))
        badgesList.add(Fragment_04_01_02_badges_Data("'강연의 신'",5))
        badgesList.add(Fragment_04_01_02_badges_Data("'어필의 신'",6))
        badgesList.add(Fragment_04_01_02_badges_Data("'소통의 시작'",7))
        badgesList.add(Fragment_04_01_02_badges_Data("'전시의 달인'",8))
        badgesList.add(Fragment_04_01_02_badges_Data("'포트폴리오 달인'",9))
        badgesList.add(Fragment_04_01_02_badges_Data("'VIP'",10))
        badgesList.add(Fragment_04_01_02_badges_Data("'비싼 몸'",11))
        badgesList.add(Fragment_04_01_02_badges_Data("'관람객'",12))



    }


}