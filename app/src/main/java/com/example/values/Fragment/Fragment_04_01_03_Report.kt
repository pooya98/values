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
import com.example.values.databinding.Fragment040103ReportBinding
import java.util.logging.Handler
import kotlin.concurrent.timer


class Fragment_04_01_03_Report : Fragment() ,View.OnClickListener{

    private var mBinding : Fragment040103ReportBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040103ReportBinding.inflate(inflater, container,false)

        mBinding = binding


        var second = 0;
        timer(period = 1000){

            second++
            if(second == 4){
                findNavController().popBackStack()
            }

        }


        return mBinding?.root
    }


    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }


    override fun onClick(v: View?) {

//        when(v?.id){
//
//            R.id.fragment04_radio1 -> {
////                findNavController().navigate(R.id.action_fragment_04_01_03_Report_to_fragment_04_01)
//
//            }
//            R.id.fragment04_radio2 -> {
//                findNavController().navigate(R.id.action_fragment_04_01_03_Report_to_fragment_04_01_02)
//            }
//            R.id.fragment04_radio4 -> {
//                findNavController().navigate(R.id.action_fragment_04_01_03_Report_to_fragment_04_01_04)
//            }
//        }
    }




}