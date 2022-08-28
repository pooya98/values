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
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }


}