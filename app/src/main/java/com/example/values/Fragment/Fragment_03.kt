package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.values.R
import com.example.values.databinding.Fragment03Binding


class Fragment_03 : Fragment() {

    private var mBinding : Fragment03Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment03Binding.inflate(inflater, container,false)

        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }


}