package com.riseup.viewpager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.values.R

class fragment_two : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page2, container, false)

        val anim_alpha1 = AnimationUtils.loadAnimation(context, R.anim.alpha1)
        val anim_alpha2 = AnimationUtils.loadAnimation(context, R.anim.alpha2)
        val anim_alpha3 = AnimationUtils.loadAnimation(context, R.anim.alpha3)
        val anim_alpha4 = AnimationUtils.loadAnimation(context, R.anim.alpha4)

        val text_01 = view.findViewById<TextView>(R.id.on02_1)
        val text_02 = view.findViewById<TextView>(R.id.on02_2)
        val text_03 = view.findViewById<TextView>(R.id.on02_3)
        val text_04 = view.findViewById<TextView>(R.id.on02_4)

        text_01.animation = (anim_alpha1)
        text_02.animation = (anim_alpha2)
        text_03.animation = (anim_alpha3)
        text_04.animation = (anim_alpha4)

        return view
    }
}