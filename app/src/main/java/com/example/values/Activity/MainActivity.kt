package com.example.values.Activity

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.values.DTO.Fragment_01_02_shop_goods_data
import com.example.values.DTO.Goods_Data
import com.example.values.Fragment.Fragment_01_02
import com.example.values.Fragment.Fragment_01_02_Shop
import com.example.values.R
import com.example.values.R.id.*
import com.example.values.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

val DB_NAME = "sqlite.sql"
val DB_VERSION = 4

//UMZZI
val USER_ID = 9


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
     val helper = SqliteHelper(this, DB_NAME, DB_VERSION)


    @SuppressLint("ResourceType") // 아래 getColorStateList를 쓸 때 값을 int형으로 받아와야하는데 바로 drawable에서 파일로 받아올수 있게해줌.(하단navigation bar 색 변경시에 사용)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

//        초기 유저 , 굿즈 더미 삽입.
//          initUsers()
//          initGoods()

        val user = helper.selectUser(USER_ID)
        val mainUserProfile = findViewById<ImageView>(R.id.main_userProfile)

        mainUserProfile.setImageBitmap(BitmapFactory.decodeByteArray(user.user_Image,0,user.user_Image!!.size))



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


    fun navigateToFragment(destination: String){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController

        when(destination){
            "fragment_01_01_ExhibitionDetail" -> navController.navigate(action_fragment_01_to_fragment_01_01_ExhibitionDetail)
            "fragment_01_01_Subscribe" -> navController.navigate(action_fragment_01_01_ExhibitionDetail_to_fragment_01_01_Subscribe)
            "fragment_01_01_Purchase" -> navController.navigate(action_fragment_01_01_ExhibitionDetail_to_fragment_01_01_Purchase)
            "fragment_02_01_SpacePick" -> navController.navigate(action_fragment_02_to_fragment_02_01_SpacePick)
            "fragment_01_02_Shop" -> navController.navigate(action_fragment_01_to_fragment_01_02_Shop)
            "fragment_04_01_04_Portfolio_Detail" -> navController.navigate(fragment_04_01_04_Portfolio_Detail)
        }
    }

    fun navigateToFragment(destination: String,goodsData: Goods_Data){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        Log.d("title2",goodsData.goods_name)
        Log.d("destination",destination)
        when(destination){
            "fragment_01_02_Shop" ->{
                val bundle = Bundle()

                bundle.putString("price",goodsData.goods_price)
                bundle.putByteArray("mainview",goodsData.goods_image)
                bundle.putInt("author_id",goodsData.author_id)
                bundle.putString("title",goodsData.goods_name)


                Log.d("MainActivity","Check2222")

//                "mainView" to goodsData.goods_image,
//                "pirce" to goodsData.goods_price,
//                "author_id" to goodsData.author_id,
//                "title" to goodsData.goods_name



                    navController.navigate(fragment_01_02_Shop, bundle)

            }
        }
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

    fun initGoods(){

        val drawable1 = getDrawable(R.drawable.goods_branding1)
        val drawable2 = getDrawable(R.drawable.goods_branding2)
        val drawable3 = getDrawable(R.drawable.goods_branding3)
        val drawable4 = getDrawable(R.drawable.goods_branding4)
        val drawable5 = getDrawable(R.drawable.goods_branding5)
        helper.insertGoods(1,8,"Animal 자석","4,500",1,drawable1)
        helper.insertGoods(2,7,"라인즈 카드","1,500",1,drawable2)
        helper.insertGoods(3,9,"Boice Pack","2,000",1,drawable3)
        helper.insertGoods(4,7,"Animal 액자카드","4,500",1,drawable4)
        helper.insertGoods(5,9,"슬좌생 Book","4,500",1,drawable5)





        val drawable_1 = getDrawable(R.drawable.goods_ill1)
        val drawable_2 = getDrawable(R.drawable.goods_ill2)
        val drawable_3 = getDrawable(R.drawable.goods_ill3)
        val drawable_4 = getDrawable(R.drawable.goods_ill4)
        val drawable_5 = getDrawable(R.drawable.goods_ill5)

        helper.insertGoods(6,7,"일러스트 스티커","1,200",2,drawable_1)
        helper.insertGoods(7,9,"인물 우표","3,000",2,drawable_2)
        helper.insertGoods(8,8,"sleepBear 책","7,500",2,drawable_3)
        helper.insertGoods(9,9,"Baseball 스티커","1,000",2,drawable_4)
        helper.insertGoods(10,8,"말꼬리 가방","12,4500",2,drawable_5)
    }

    fun initUsers(){

        val drawable1 = getDrawable(R.drawable.user1_profile)
        val drawable2 = getDrawable(R.drawable.user2_profile)
        val drawable3 = getDrawable(R.drawable.user3_profile)
        helper.insertUser(7,"sengwoo",drawable1)
        helper.insertUser(8,"yunsu",drawable2)
        helper.insertUser(9,"UMZZI",drawable3)

    }



}