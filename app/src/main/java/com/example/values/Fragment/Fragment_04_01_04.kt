package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.values.R
import com.example.values.databinding.Fragment040104Binding


class Fragment_04_01_04 : Fragment() ,View.OnClickListener{

    private var mBinding : Fragment040104Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040104Binding.inflate(inflater, container,false)

        mBinding = binding




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
////                findNavController().navigate(R.id.action_fragment_04_01_04_to_fragment_04_01)
//
//            }
//            R.id.fragment04_radio2 -> {
//                findNavController().navigate(R.id.action_fragment_04_01_04_to_fragment_04_01_02)
//            }
//            R.id.fragment04_radio3 -> {
//                findNavController().navigate(R.id.action_fragment_04_01_04_to_fragment_04_01_03)
//            }
//        }
    }


}