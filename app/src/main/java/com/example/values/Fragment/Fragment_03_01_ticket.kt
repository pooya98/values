package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.values.Activity.MainActivity
import com.example.values.R
import com.example.values.databinding.Fragment0301TicketBinding


class Fragment_03_01_ticket : Fragment() {

    private var mBinding : Fragment0301TicketBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment0301TicketBinding.inflate(inflater, container,false)


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

        (activity as MainActivity).hideLogoAndShowBackButton("최근 예매 확인")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("최근 예매 확인")
    }

}