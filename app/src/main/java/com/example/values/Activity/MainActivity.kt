package com.example.values.Activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.values.R
import com.example.values.R.id.*
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

        val backbutton = findViewById<LinearLayout>(R.id.mainactivity_linearlayout_back)
        backbutton.setOnClickListener{
            navController.navigateUp()
        }

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
        mBinding.mainactivityBottomNavigation.setBackgroundColor(Color.parseColor("#7600FF"))//대희 purple color
        mBinding.activityMainLayout.setBackgroundColor(Color.parseColor("#7600FF"))
        window.statusBarColor = Color.parseColor("#7600FF")

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

    fun navigateToFragment_portFolioDetail(){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        navController.navigate(fragment_04_01_04_Portfolio_Detail)
    }

    fun navigateToFragment_01_01_ExhibitionDetail(){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        navController.navigate(action_fragment_01_to_fragment_01_01_ExhibitionDetail)
    }

    fun navigateToFragment_01_01_Subscribe(){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        navController.navigate(action_fragment_01_01_ExhibitionDetail_to_fragment_01_01_Subscribe)
    }

    fun navigateToFragment_01_01_Purchase(){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        navController.navigate(action_fragment_01_01_ExhibitionDetail_to_fragment_01_01_Purchase)
    }


    fun hideLogoAndShowBackButton(backButtonName: String){

        val logo = findViewById<ImageView>(R.id.mainactivity_logo)
        logo.visibility = View.INVISIBLE

        val backButtonText = findViewById<TextView>(R.id.mainactivity_backname)
        backButtonText.text = backButtonName

        val backButton = findViewById<LinearLayout>(R.id.mainactivity_linearlayout_back)
        backButton.visibility = View.VISIBLE
        val backButtonArrow = findViewById<ImageView>(R.id.backArrow)

        if(backButtonName=="최근 예매 확인"||backButtonName=="참여형 이벤트"){
            backButtonArrow.setImageResource(R.drawable.icon_left_white_arrow)
            backButtonText.setTextColor(Color.WHITE)
        }else{
            backButtonArrow.setImageResource(R.drawable.icon_left_black_arrow)
            backButtonText.setTextColor(Color.parseColor("#282828"))
        }

    }

    fun hideBackButtonAndShowLogo(){
        val backButton = findViewById<LinearLayout>(R.id.mainactivity_linearlayout_back)
        backButton.visibility = View.INVISIBLE

        val logo = findViewById<ImageView>(R.id.mainactivity_logo)
        logo.visibility = View.VISIBLE
    }
}