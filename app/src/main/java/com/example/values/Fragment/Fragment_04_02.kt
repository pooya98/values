package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_04_02_Adapter
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.R
import com.example.values.databinding.Fragment0402Binding


class Fragment_04_02 : Fragment() {

    lateinit var recyclerView : RecyclerView
    private val eventList = ArrayList<Fragment_04_02_Data>()


    private var mBinding : Fragment0402Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment0402Binding.inflate(inflater, container,false)

        mBinding = binding

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view?.findViewById(R.id.eventRecyclerView)!!

        fillList()
        val f042Adapter = Fragment_04_02_Adapter(eventList)
        recyclerView.adapter = f042Adapter
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)


      /*recyclerView의 아이템이 마지막에 도착할때 이벤트처리.*/
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager)
                        .findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter?.itemCount?.minus(1)

                if (lastVisibleItemPosition != itemTotalCount) {

                }else{
                    Toast.makeText(activity,"더이상 참여중인 이벤트가 없어요",Toast.LENGTH_SHORT).show()
                }
            }
        })

    }



    fun fillList(){
        eventList.add(Fragment_04_02_Data("QR코드로 관람인증하고 커피도 받자","22.01.01-22.12.31","294","37"))
        eventList.add(Fragment_04_02_Data("무료강연 소감 작성하고 선물까지!","22.05.01-22.05.31","134","22"))
        eventList.add(Fragment_04_02_Data("전시 리뷰 작성하고 굳즈도 받고!","22.05.01-22.05.31","97","18"))


    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideBackButtonAndShowLogo()
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideBackButtonAndShowLogo()
    }



    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
        eventList.clear()
    }



}