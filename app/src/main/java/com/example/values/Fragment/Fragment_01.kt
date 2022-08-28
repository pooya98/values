package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.values.R
import com.example.values.databinding.Fragment01Binding

class Fragment_01 : Fragment(), View.OnClickListener {

    private var mBinding : Fragment01Binding? = null
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment01Binding.inflate(inflater, container, false)

        mBinding = binding

        var navHostFragment = childFragmentManager.findFragmentById(R.id.fragment01_FrameLayout) as NavHostFragment
        navController = navHostFragment.navController

        mBinding?.fragment01Radio1?.setOnClickListener(this)
        mBinding?.fragment01Radio2?.setOnClickListener(this)
        mBinding?.fragment01Radio3?.setOnClickListener(this)
        mBinding?.fragment01Radio4?.setOnClickListener(this)

        // Inflate the layout for this fragment
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.fragment01_radio1 -> {
                navController.navigate(R.id.fragment_01_01)
            }
            R.id.fragment01_radio2 -> {
                navController.navigate(R.id.fragment_01_02)
            }
            R.id.fragment01_radio3 -> {
                navController.navigate(R.id.fragment_01_03)
            }
            R.id.fragment01_radio4 -> {
                navController.navigate(R.id.fragment_01_04)
            }

        }
    }
}