package com.example.values.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.values.Adapter.ViewPagerFragmentAdapter
import com.example.values.R
import com.riseup.viewpager.fragment.fragment_four
import com.riseup.viewpager.fragment.fragment_one
import com.riseup.viewpager.fragment.fragment_three
import com.riseup.viewpager.fragment.fragment_two
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import me.relex.circleindicator.CircleIndicator3

class OnBoarding : AppCompatActivity() {

    private val data = mutableListOf<String>()
    private val fragmentList = ArrayList<Fragment>()
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: SpringDotsIndicator
    private lateinit var button_next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        castView()
        addToList()
        fragmentList.add(fragment_one())
        fragmentList.add(fragment_two())
        fragmentList.add(fragment_three())
        fragmentList.add(fragment_four())

        viewPager.adapter = ViewPagerFragmentAdapter(this, fragmentList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        indicator.setViewPager2(viewPager)



        button_next.setOnClickListener {
            var position = viewPager.currentItem

            Log.d("포지션", position.toString())


            if (position == 0){
                position++
                viewPager.currentItem = position
            }
            else if(position == 1){
                position++
                viewPager.currentItem = position
            }
            else if(position == 2){
                button_next.setText("시작하기")
                position++
                viewPager.currentItem = position
            }
            else{
                finish()
            }
        }


    }

    private fun castView() {

        viewPager = findViewById(R.id.view_pager2)
        indicator = findViewById(R.id.indicator)
        button_next = findViewById(R.id.button_next)

    }

    private fun addToList() {
        for (item in 1..4) {
            data.add("item $item")
        }
    }
}