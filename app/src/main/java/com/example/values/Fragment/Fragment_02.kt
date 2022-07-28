package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.values.R
import com.example.values.databinding.Fragment01Binding
import com.example.values.databinding.Fragment02Binding

class Fragment_02 : Fragment(), View.OnClickListener  {

    private var mBinding : Fragment02Binding? = null
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment02Binding.inflate(inflater, container, false)

        mBinding = binding

        var navHostFragment = childFragmentManager.findFragmentById(R.id.fragment02_FrameLayout) as NavHostFragment
        navController = navHostFragment.navController

        mBinding?.fragment02Radio1?.setOnClickListener(this)
        mBinding?.fragment02Radio2?.setOnClickListener(this)
        mBinding?.fragment02Radio3?.setOnClickListener(this)

        // Inflate the layout for this fragment
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.fragment02_radio1 -> {
                navController.navigate(R.id.fragment_02_01)

            }
            R.id.fragment02_radio2 -> {
                navController.navigate(R.id.fragment_02_02)
            }
            R.id.fragment02_radio3 -> {
                navController.navigate(R.id.fragment_02_03)
            }
        }
    }
}