package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Adapter.Fragment_01_04_Adapter
import com.example.values.DTO.Fragment_01_04_Data
import com.example.values.R

class Fragment_01_04 : Fragment() {
    lateinit var fragment_01_04_Adapter: Fragment_01_04_Adapter
    val datas = mutableListOf<Fragment_01_04_Data>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_01_04, container, false)
        val recyclerview = view.findViewById<RecyclerView>(R.id.fragment_01_04_recyclerview)

        initRecycler(recyclerview)
        return view
    }

    private fun initRecycler(rv_list: RecyclerView) {
        fragment_01_04_Adapter = Fragment_01_04_Adapter(this)
        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = fragment_01_04_Adapter


        datas.apply {
            add(Fragment_01_04_Data(title = "기타 컨텐츠 아이템의 메인 제목", description = "기타 컨텐츠 리스트뷰 아이템의 세부 내용 설명"))
            add(Fragment_01_04_Data(title = "기타 컨텐츠 아이템의 메인 제목", description = "기타 컨텐츠 리스트뷰 아이템의 세부 내용 설명"))
            add(Fragment_01_04_Data(title = "기타 컨텐츠 아이템의 메인 제목", description = "기타 컨텐츠 리스트뷰 아이템의 세부 내용 설명"))
            add(Fragment_01_04_Data(title = "기타 컨텐츠 아이템의 메인 제목", description = "기타 컨텐츠 리스트뷰 아이템의 세부 내용 설명"))

            fragment_01_04_Adapter.datas = datas
            fragment_01_04_Adapter.notifyDataSetChanged()

        }
    }
}