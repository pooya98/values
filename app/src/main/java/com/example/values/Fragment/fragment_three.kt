package com.riseup.viewpager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.values.R

class fragment_three : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page3, container, false)

        val anim_alpha1 = AnimationUtils.loadAnimation(context, R.anim.alpha1)
        val anim_alpha2 = AnimationUtils.loadAnimation(context, R.anim.alpha2)


        val text_01 = view.findViewById<LinearLayout>(R.id.values01)
        val text_02 = view.findViewById<LinearLayout>(R.id.values02)

        text_01.animation = (anim_alpha1)
        text_02.animation = (anim_alpha2)


        return view
    }
}