package com.example.values.Fragment

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
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_04_01_02_badges_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio2_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio_Adapter
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.R
import com.example.values.databinding.Fragment040104Binding


class Fragment_04_01_04 : Fragment() ,View.OnClickListener{

    private val pictureList = ArrayList<Fragment_04_01_04_portfolio_Data>()
    private val pictureList2 = ArrayList<Fragment_04_01_04_portfolio_Data>()

    private var mBinding : Fragment040104Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040104Binding.inflate(inflater, container,false)

        mBinding = binding
        var recyclerView = mBinding?.portfolioRecycler
        var recyclerView2 = mBinding?.portfolioRecycler2

        fillList2()
        fillList()

        val pictureAdapter = Fragment_04_01_04_portfolio_Adapter(pictureList,(activity as MainActivity))
        val pictureAdapter2 = Fragment_04_01_04_portfolio2_Adapter(pictureList2)
        recyclerView?.adapter = pictureAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        recyclerView2?.adapter = pictureAdapter2
        recyclerView2?.layoutManager = GridLayoutManager(activity,2)



        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

    override fun onClick(v: View?) {

        when(v?.id){

        }
    }

    fun fillList(){    //전시중인 작품 .

        pictureList.add(Fragment_04_01_04_portfolio_Data("대한민국 대세 미녀는 누구인가?"))
        pictureList.add(Fragment_04_01_04_portfolio_Data("ㅇㅈ?"))
        pictureList.add(Fragment_04_01_04_portfolio_Data("ㅇ ㅇㅈ~"))
        pictureList.add(Fragment_04_01_04_portfolio_Data("비유티풀"))
        pictureList.add(Fragment_04_01_04_portfolio_Data("비이유티풀"))

    }


    fun fillList2(){    //작품 .

        pictureList2.add(Fragment_04_01_04_portfolio_Data("팝아트,유화로 다시 태어나다! 재해석작 모음"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("헤응"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("호호호"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("빵빵빵"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("비이유티풀"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("2"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("4"))
        pictureList2.add(Fragment_04_01_04_portfolio_Data("5"))

    }


}