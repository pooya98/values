package com.example.values.Activity

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.values.Fragment.Fragment_01
import com.example.values.Fragment.Fragment_02
import com.example.values.Fragment.Fragment_03
import com.example.values.Fragment.Fragment_04
import com.example.values.R
import com.example.values.R.drawable.selector_bottom_navi_color
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType") // 아래 getColorStateList를 쓸 때 값을 int형으로 받아와야하는데 바로 drawable에서 파일로 받아올수 있게해줌.(하단navigation bar 색 변경시에 사용)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // <------ 레이아웃 뷰 선언 ------> //

        // 하단 네비게이션 바
        val bottomMenu = findViewById<BottomNavigationView>(R.id.mainactivity_bottom_navigation)

         fun bottomColor(i:Int){
             if(i==3){
                 bottomMenu.itemTextColor = ContextCompat.getColorStateList(this,R.drawable.selector_bottom_navi_color)
                 bottomMenu.itemIconTintList = ContextCompat.getColorStateList(this,R.drawable.selector_bottom_navi_color)
                 bottomMenu.setBackgroundColor(Color.parseColor("#7735FF"))
             }else{
                 bottomMenu.itemTextColor = ContextCompat.getColorStateList(this,R.drawable.selector_bottom_navi_color_origin)
                 bottomMenu.itemIconTintList = ContextCompat.getColorStateList(this,R.drawable.selector_bottom_navi_color_origin)
                 bottomMenu.setBackgroundColor(Color.parseColor("#FFFFFF"))
             }
        }


        // <------ 뷰 이벤트 리스너 선언 ------> //

        // 하단 네비게이션 바 클릭 리스너
        bottomMenu.run { setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_01()).commit()
                    bottomColor(1)
                }
                R.id.display -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_02()).commit()
                    bottomColor(2)
                }
                R.id.ticketing -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_03()).commit()
                    bottomColor(3)
                }
                R.id.menu -> {
                    supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_04()).commit()
                    bottomColor(4)
                }
            }
            true
        } }

        // <------ 초기 실행해야할 부분 ------> //
        supportFragmentManager.beginTransaction().replace(R.id.Main_FrameLayout, Fragment_01()).commit()

    }
}