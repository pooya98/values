package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_03_01_Adapter
import com.example.values.Adapter.Fragment_04_01_03_Adapter
import com.example.values.Adapter.Fragment_04_02_Adapter
import com.example.values.DTO.Fragment_03_01_Data
import com.example.values.DTO.Fragment_04_01_03_Data
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.R
import com.example.values.databinding.Fragment0301Binding


class Fragment_03_01 : Fragment() ,View.OnClickListener{

    lateinit var recyclerView: RecyclerView
    private val myExhibitList = ArrayList<Fragment_03_01_Data>()
    private var mBinding : Fragment0301Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment0301Binding.inflate(inflater, container,false)

        mBinding = binding




        return mBinding?.root
    }


    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view?.findViewById(R.id.exhibitRecyclerView)!!

        fillList()
        val f0301Adapter = Fragment_03_01_Adapter(myExhibitList)
        recyclerView.adapter = f0301Adapter
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)





    }

    override fun onClick(v: View?) {

        when(v?.id){

        }
    }

    fun fillList(){
        myExhibitList.add(Fragment_03_01_Data("팝아트,유화로 다시 태어나다!","6/13 MON","3,000 결제완료","2층 B홀 -[일러스트]","D-3","purple"))
        myExhibitList.add(Fragment_03_01_Data("내 손으로 직접하는 실크스크린","6/18 SAT","무료","1층 센터홀 -[체험부스]","D-8","secondPurple"))
        myExhibitList.add(Fragment_03_01_Data("안전 지킴이 브랜딩 패키지","5/25 TUE","3,000 결제완료","2층 A홀 -[일러스트]","D+24","gray"))
        myExhibitList.add(Fragment_03_01_Data("공공빅데이터 UI/UX 앱제작","5/19 WED","3,000 결제완료","2층 B홀 -[일러스트]","D+30","gray"))

    }


}