package com.riseup.viewpager.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.values.R

class fragment_two : Fragment(){

    var fadeOut1 : ObjectAnimator? = null
    var fadeOut2 : ObjectAnimator? = null
    var fadeOut3 : ObjectAnimator? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page2, container, false)

        val text_01 = view.findViewById<TextView>(R.id.on02_1)
        val text_02 = view.findViewById<TextView>(R.id.on02_2)
        val text_03 = view.findViewById<TextView>(R.id.on02_3)

        fadeOut1 = ObjectAnimator.ofFloat(text_01, "alpha", 0f, 1f)
        fadeOut1?.duration = 2000
        fadeOut1?.start()


        fadeOut2 = ObjectAnimator.ofFloat(text_02, "alpha", 0f, 1f)
        fadeOut2?.startDelay = 2000
        fadeOut2?.duration = 2000
        fadeOut2?.start()

        fadeOut3 = ObjectAnimator.ofFloat(text_03, "alpha", 0f, 1f)
        fadeOut3?.duration = 2000
        fadeOut3?.startDelay = 4000
        fadeOut3?.start()



        return view
    }
}