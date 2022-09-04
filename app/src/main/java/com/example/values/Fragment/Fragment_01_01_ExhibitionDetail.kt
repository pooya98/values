package com.example.values.Fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.values.Activity.MainActivity
import com.example.values.R

class Fragment_01_01_ExhibitionDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_01_01__exhibition_detail, container, false)

        // Inflate the layout for this fragment

        val subscribe_button = view.findViewById<Button>(R.id.fragment_01_01_ExhibitionDetail_button_subscribe)
        val purchase_button = view.findViewById<Button>(R.id.fragment_01_01_ExhibitionDetail_button_purchase)

        subscribe_button.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_01_01_Subscribe")
        }
        purchase_button.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_01_01_Purchase")
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("진행중인 전시")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("진행중인 전시")
    }

}