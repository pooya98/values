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
import com.example.values.Adapter.Fragment_04_01_03_Adapter
import com.example.values.Adapter.Fragment_04_02_Adapter
import com.example.values.DTO.Exhibition_Data
import com.example.values.DTO.Fragment_04_01_03_Data
import com.example.values.DTO.Fragment_04_02_Data
import com.example.values.R
import com.example.values.databinding.Fragment040103Binding


class Fragment_04_01_03 : Fragment() ,View.OnClickListener{

//    lateinit var recyclerView: RecyclerView
    private var myExhibitList = ArrayList<Exhibition_Data>()
    private var mBinding : Fragment040103Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040103Binding.inflate(inflater, container,false)

        mBinding = binding

        var recyclerView = mBinding?.myExhibitRecyclerView

        myExhibitList = (activity as MainActivity).helper.selectExhibtionsByUserId((activity as MainActivity).USER_ID)
        val f040103Adapter = Fragment_04_01_03_Adapter(myExhibitList)
        recyclerView?.adapter = f040103Adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)




        return mBinding?.root
    }


    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }


    override fun onClick(v: View?) {

        when(v?.id){

        }
    }




}