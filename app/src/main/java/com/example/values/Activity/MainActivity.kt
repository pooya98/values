package com.example.values.Activity

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.values.R
import com.example.values.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    @SuppressLint("ResourceType") // 아래 getColorStateList를 쓸 때 값을 int형으로 받아와야하는데 바로 drawable에서 파일로 받아올수 있게해줌.(하단navigation bar 색 변경시에 사용)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment?
                ?: return
        val navController = host.navController
//        val mButton = findViewById<Button>(R.id.detailButton)
//        mButton?.setOnClickListener { view->view.findNavController().navigate(R.id.action_fragment_03_to_fragment_03_01_ticket)  }

        setupBottomNavMenu(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        val navigationView = findViewById<NavigationView>(R.id.main_navigation)
        if (navigationView == null) {
            menuInflater.inflate(R.menu.mainactivity_menu, menu)
            return true
        }
        return retValue
    }


    @SuppressLint("ResourceType")
    fun callTicket() {
        mBinding.mainactivityBottomNavigation.itemTextColor =
            ContextCompat.getColorStateList(this, R.drawable.selector_bottom_navi_color)
        mBinding.mainactivityBottomNavigation.itemIconTintList =
            ContextCompat.getColorStateList(this, R.drawable.selector_bottom_navi_color)
        mBinding.mainactivityBottomNavigation.setBackgroundColor(Color.parseColor("#FF6200EE"))//대희 purple color
        mBinding.activityMainLayout.setBackgroundColor(Color.parseColor("#FF6200ee"))
        window.statusBarColor = Color.parseColor("#FF6200EE")

    }

    @SuppressLint("ResourceType")
    fun callElse() {
        mBinding.mainactivityBottomNavigation.itemTextColor =
            ContextCompat.getColorStateList(this, R.drawable.selector_bottom_navi_color_origin)
        mBinding.mainactivityBottomNavigation.itemIconTintList =
            ContextCompat.getColorStateList(this, R.drawable.selector_bottom_navi_color_origin)
        mBinding.mainactivityBottomNavigation.setBackgroundColor(Color.parseColor("#FFFFFF"))
        mBinding.activityMainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
        window.statusBarColor = Color.parseColor("#FFFFFF")


    }


    @SuppressLint("ResourceType")
    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.mainactivity_bottom_navigation)
        bottomNav?.setupWithNavController(navController)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)

        return item.onNavDestinationSelected(findNavController(R.id.Main_FrameLayout))
                || super.onOptionsItemSelected(item)
    }
}