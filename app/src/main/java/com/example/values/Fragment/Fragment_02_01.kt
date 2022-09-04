package com.example.values.Fragment

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.example.values.Activity.MainActivity
import com.example.values.R
import com.example.values.databinding.Fragment0201Binding
import com.example.values.databinding.Fragment02Binding

class Fragment_02_01 : Fragment() {

    private var mBinding : Fragment0201Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_02_01, container, false)

        val linearLayout_pick_space = view.findViewById<LinearLayout>(R.id.LinearLayout_pick_space)
        val search_button = view.findViewById<Button>(R.id.fragment_02_01_Search_Button)

        linearLayout_pick_space.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_02_01_SpacePick")
        }

        search_button.setOnClickListener{
            findNavController().navigate(R.id.action_fragment_02_01_to_fragment_02_01_ExhibitionAvailable)
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideBackButtonAndShowLogo()
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideBackButtonAndShowLogo()
    }


    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }

}