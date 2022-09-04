package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_04_01_02_badges_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio2_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio_Adapter
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.R
import com.example.values.databinding.Fragment040104Binding
import com.example.values.databinding.Fragment040104PortfolioDetailBinding


class Fragment_04_01_04_Portfolio_Detail : Fragment() ,View.OnClickListener{



    private var mBinding : Fragment040104PortfolioDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040104PortfolioDetailBinding.inflate(inflater, container,false)

        mBinding = binding




        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }

    override fun onClick(v: View?) {

        when(v?.id){

        }
    }




}