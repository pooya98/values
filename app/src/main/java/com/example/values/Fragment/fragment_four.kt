package com.riseup.viewpager.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.values.R

class fragment_four: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page4, container, false)

        val anim_alpha1 = AnimationUtils.loadAnimation(context, R.anim.alpha1)

        val image = view.findViewById<ImageView>(R.id.omg)

        image.startAnimation(anim_alpha1)

        return view
    }
}