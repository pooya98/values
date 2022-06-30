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
    }
}