package com.riseup.viewpager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.test.core.app.ActivityScenario.launch
import com.example.values.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

class fragment_one : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_page, container, false)

        var anim_alpha1 = AnimationUtils.loadAnimation(context, R.anim.alpha1)
        var anim_alpha2 = AnimationUtils.loadAnimation(context, R.anim.alpha2)
        var anim_alpha3 = AnimationUtils.loadAnimation(context, R.anim.alpha3)
        var anim_alpha4 = AnimationUtils.loadAnimation(context, R.anim.alpha4)

        val text_01 = view.findViewById<TextView>(R.id.on01_1)
        val text_02 = view.findViewById<TextView>(R.id.on01_2)
        val text_03 = view.findViewById<TextView>(R.id.on01_3)
        val text_04 = view.findViewById<TextView>(R.id.on01_4)

        text_01.animation = (anim_alpha1)
        text_02.animation = (anim_alpha2)
        text_03.animation = (anim_alpha3)
        text_04.animation = (anim_alpha4)

        return view
    }
}