package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.values.Activity.MainActivity
import com.example.values.R
import com.example.values.databinding.Fragment03Binding


class Fragment_03 : Fragment() {

    private var mBinding : Fragment03Binding? = null
    lateinit var navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment03Binding.inflate(inflater, container,false)

        mBinding = binding
        var navHostFragment = childFragmentManager.findFragmentById(R.id.fragment02_FrameLayout) as NavHostFragment
        navController = navHostFragment.navController

                navController.addOnDestinationChangedListener {_,destination,_->

            if(destination.id == R.id.fragment_03_01_ticket){
                mBinding?.fragment03RadioGroup?.visibility=View.INVISIBLE    //ticket화면으로 전환시 라디오그룹 숨기기.
                (activity as MainActivity).callTicket()                      //바텀네비 변경.
            }else{
                mBinding?.fragment03RadioGroup?.visibility=View.VISIBLE

            }
        }
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }


}