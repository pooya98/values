package com.riseup.viewpager.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.test.core.app.ActivityScenario.launch
import com.example.values.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

class fragment_one : Fragment(){
    //Created by Jaydeep Motisariya
    //Date 16th Oct 2021

    var fadeOut1 : ObjectAnimator? = null
    var fadeOut2 : ObjectAnimator? = null
    var fadeOut3 : ObjectAnimator? = null
    var fadeOut4 : ObjectAnimator? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page, container, false)

        val text_01 = view.findViewById<TextView>(R.id.on01_1)
        val text_02 = view.findViewById<TextView>(R.id.on01_2)
        val text_03 = view.findViewById<TextView>(R.id.on01_3)
        val text_04 = view.findViewById<TextView>(R.id.on01_4)

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

        fadeOut4 = ObjectAnimator.ofFloat(text_04, "alpha", 0f, 1f)
        fadeOut4?.duration = 2000
        fadeOut4?.startDelay = 6000
        fadeOut4?.start()





        return view
    }
}