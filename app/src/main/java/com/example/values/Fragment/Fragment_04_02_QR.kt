package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.values.Activity.MainActivity
import com.example.values.R
import com.example.values.databinding.Fragment0402QrBinding


class Fragment_04_02_QR : Fragment() {

    private var mBinding : Fragment0402QrBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment0402QrBinding.inflate(inflater, container,false)


        mBinding = binding


        return mBinding?.root
    }

    override fun onDestroyView() {
        (activity as MainActivity).callElse()
        (activity as MainActivity).hideBackButtonAndShowLogo()
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

    override fun onStart() {
        super.onStart()
        super.onResume()
        (activity as MainActivity).callTicket()
        (activity as MainActivity).hideLogoAndShowBackButton("참여형 이벤트")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("참여형 이벤트")
    }

}