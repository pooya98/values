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
import com.example.values.Adapter.Fragment_04_01_03_Adapter
import com.example.values.Adapter.Fragment_04_02_Adapter
import com.example.values.DTO.Fragment_04_01_03_Data
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.R
import com.example.values.databinding.Fragment040103Binding


class Fragment_04_01_03 : Fragment() ,View.OnClickListener{

    lateinit var recyclerView: RecyclerView
    private val myExhibitList = ArrayList<Fragment_04_01_03_Data>()
    private var mBinding : Fragment040103Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040103Binding.inflate(inflater, container,false)

        mBinding = binding




        return mBinding?.root
    }


    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view?.findViewById(R.id.myExhibitRecyclerView)!!

        fillList()
        val f040103Adapter = Fragment_04_01_03_Adapter(myExhibitList)
        recyclerView.adapter = f040103Adapter
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)





    }

    override fun onClick(v: View?) {

        when(v?.id){

        }
    }

    fun fillList(){
        myExhibitList.add(Fragment_04_01_03_Data("팝아트,유화로 다시 태어나다","8/25 - 8/28","유료","2층 B홀 -[일러스트]"))
        myExhibitList.add(Fragment_04_01_03_Data("큐티한 동물 감스트","8/2 - 8/5","유료","1층 C홀 -[감스트]"))
        myExhibitList.add(Fragment_04_01_03_Data("실크스크린 캐릭터 표현","9/22 - 9/30","무료","2층 A홀 -[러스트]"))

    }


}