package com.example.values.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.values.Fragment.Fragment_01
import com.example.values.Fragment.Fragment_02
import com.example.values.Fragment.Fragment_03
import com.example.values.Fragment.Fragment_04
import com.example.values.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // <------ 레이아웃 뷰 선언 ------> //

        // 하단 네비게이션 바
        val bottomMenu = findViewById<BottomNavigationView>(R.id.mainactivity_bottom_navigation)



        // <------ 뷰 이벤트 리스너 선언 ------> //

        // 하단 네비게이션 바 클릭 리스너
        bottomMenu.run { setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_01()).commit()
                }
                R.id.display -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_02()).commit()
                }
                R.id.ticketing -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_03()).commit()
                }
                R.id.menu -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_04()).commit()
                }
            }
            true
        } }

        // <------ 초기 실행해야할 부분 ------> //
        supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_01()).commit()

    }
}