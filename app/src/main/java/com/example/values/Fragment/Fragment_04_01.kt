package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.findFragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.values.R
import com.example.values.databinding.Fragment0401Binding
import com.google.android.material.navigation.NavigationView


class Fragment_04_01 : Fragment() ,View.OnClickListener{



    private var mBinding : Fragment0401Binding? = null
    lateinit var navController : NavController// 하위프래그먼트 다루기위해 나중에 초기화.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment0401Binding.inflate(inflater, container,false)
        mBinding = binding

        var navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_04_01) as NavHostFragment
        navController = navHostFragment.navController

        mBinding?.fragment04Radio1?.setOnClickListener(this)
        mBinding?.fragment04Radio2?.setOnClickListener(this)
        mBinding?.fragment04Radio3?.setOnClickListener(this)
        mBinding?.fragment04Radio4?.setOnClickListener(this)


        return mBinding?.root
    }



    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

    override fun onClick(v: View?) {
            //navController.currentDestination
//        action_allFragment_to_fragment_04_01
        when(v?.id){
            R.id.fragment04_radio1 ->{
                navController.navigate(R.id.fragment_04_01_01)
            }

            R.id.fragment04_radio2 -> {
                navController.navigate(R.id.fragment_04_01_02)

            }
            R.id.fragment04_radio3 -> {
                navController.navigate(R.id.fragment_04_01_03)
            }
            R.id.fragment04_radio4 -> {
                navController.navigate(R.id.fragment_04_01_04)
            }
        }
    }


}