package com.riseup.viewpager.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.values.R

class fragment_three : Fragment(){

    var fadeOut3 : ObjectAnimator? = null
    //Created by Jaydeep Motisariya
    //Date 16th Oct 2021
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page3, container, false)

        val text_03 = view.findViewById<ImageView>(R.id.omg)


        fadeOut3 = ObjectAnimator.ofFloat(text_03, "alpha", 0f, 1f)
        fadeOut3?.duration = 2000
        fadeOut3?.start()


        return view
    }
}