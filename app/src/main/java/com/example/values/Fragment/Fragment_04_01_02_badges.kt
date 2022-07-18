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
        badgesList.add(Fragment_04_01_02_badges_Data("'유명세의 시작'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'죽겠다'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'살려줄사람'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'이잉 기모링'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'에이비씨디'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'자두과자'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'대구대17학번'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'금윤수입니다'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'꼬부꼬부기기기'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'하루종일종일'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'바탱탱탱볼볼'"))
        badgesList.add(Fragment_04_01_02_badges_Data("'공일공팔이이'"))



    }


}