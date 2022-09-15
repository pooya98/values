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
import com.example.values.DTO.Exhibition_Data
import com.example.values.DTO.Fragment_01_02_shop_goods_data
import com.example.values.DTO.Fragment_02_01_Address_Data
import com.example.values.DTO.Goods_Data
import com.example.values.Fragment.Fragment_01_02
import com.example.values.Fragment.Fragment_01_02_Shop
import com.example.values.R
import com.example.values.R.id.*
import com.example.values.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView




class MainActivity : AppCompatActivity() {
    val DB_NAME = "sqlite.sql"
    val DB_VERSION = 189
    //UMZZI
    val USER_ID = 9

    private lateinit var mBinding: ActivityMainBinding
     val helper = SqliteHelper(this, DB_NAME, DB_VERSION)


    @SuppressLint("ResourceType") // 아래 getColorStateList를 쓸 때 값을 int형으로 받아와야하는데 바로 drawable에서 파일로 받아올수 있게해줌.(하단navigation bar 색 변경시에 사용)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        //        초기 유저 , 굿즈 더미 삽입.

        initUsers()
        initGoods()
        initSpaces()
        initPositions()
        initExhibitions()

        initPicture()



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
        mBinding.imageNotification.setImageResource(R.drawable.icon_notification2)
        mBinding.imageMessage.setImageResource(R.drawable.icon_message2)
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

        mBinding.imageNotification.setImageResource(R.drawable.icon_notification)
        mBinding.imageMessage.setImageResource(R.drawable.icon_message)
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
            "fragment_02_01_SpacePick" -> navController.navigate(fragment_02_01_SpacePick)
            "fragment_01_02_Shop" -> navController.navigate(action_fragment_01_to_fragment_01_02_Shop)
            "fragment_04_01_04_Portfolio_Detail" -> navController.navigate(fragment_04_01_04_Portfolio_Detail)
            "fragment_02_01_ExhibitionAvailable_to_fragment_02_01_Post" -> navController.navigate(action_fragment_02_01_ExhibitionAvailable_to_fragment_02_01_Post)

        }
    }

    fun navigateToFragment(destination: String, bundle: Bundle){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController

        when(destination){
            "fragment_01_01_ExhibitionDetail" -> navController.navigate(action_fragment_01_to_fragment_01_01_ExhibitionDetail, bundle)
            "fragment_01_01_Subscribe" -> navController.navigate(action_fragment_01_01_ExhibitionDetail_to_fragment_01_01_Subscribe)
            "fragment_01_01_Purchase" -> navController.navigate(action_fragment_01_01_ExhibitionDetail_to_fragment_01_01_Purchase)
            "fragment_02_01_SpacePick" -> navController.navigate(fragment_02_01_SpacePick)
            "fragment_01_02_Shop" -> navController.navigate(action_fragment_01_to_fragment_01_02_Shop)
            "fragment_04_01_04_Portfolio_Detail" -> navController.navigate(fragment_04_01_04_Portfolio_Detail)
            "fragment_02_01_ExhibitionAvailable_to_fragment_02_01_Post" -> navController.navigate(action_fragment_02_01_ExhibitionAvailable_to_fragment_02_01_Post)

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

    fun navigateToFragment(destination: String,spaceData: Fragment_02_01_Address_Data){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        when(destination){
            "fragment_02_01" ->{
                val bundle = Bundle()

                bundle.putInt("spaceId",spaceData.space_id)
                bundle.putString("address",spaceData.address)

                //navController.navigate(fragment_02_01, bundle)

            }
        }
    }

    fun navigateToFragment(destination: String,selectStart:String,selectEnd:String,spaceId:Int,brand:String){
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.Main_FrameLayout) as NavHostFragment
        val navController = host.navController
        when(destination){
            "fragment_02_01_ExhibitionAvailable" ->{
                val bundle = Bundle()
                bundle.putString("selectStart",selectStart)
                bundle.putString("selectEnd",selectEnd)
                bundle.putString("brand",brand)
                bundle.putInt("space_id",spaceId)
                //navController.navigate(fragment_02_01_ExhibitionAvailable, bundle)

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


    fun initSpaces(){

        val drawable1 = getDrawable(R.drawable.space1)
        val drawable2 = getDrawable(R.drawable.space2)
        val drawable3 = getDrawable(R.drawable.space3)
        val drawable4 = getDrawable(R.drawable.space4)

        helper.insertSpace(1,"경북","경산",drawable1)
        helper.insertSpace(2,"대전","둔산",drawable2)
        helper.insertSpace(3,"경북","포항",drawable3)
        helper.insertSpace(4,"경북","경주",drawable2)


    }

    fun initPositions(){


        helper.insertPositions(1,"2층 A홀",1)
        helper.insertPositions(2,"1층 C홀",1)
        helper.insertPositions(3,"3층 B홀",1)
        helper.insertPositions(4,"1층 B홀",1)


    }

    fun initExhibitions(){

        helper.insertExhibitions(1,1,"09/19/2022","09/23/2022","branding")
        helper.insertExhibitions(2,1,"09/19/2022","09/23/2022","illutration")
        helper.insertExhibitions(3,1,"09/26/2022","10/03/2022","branding")
        helper.insertExhibitions(4,1,"10/06/2022","10/12/2022","branding")


    }

    fun initPicture(){

        val drawable_1 = getDrawable(R.drawable.goods_ill1)
        val text = "팝아트를 유화로 표현하여 기존 작가의 의도를 해석해 저의 방식으로 풀었습니다. 기존의 낮았던 채도를 형광으로 높이고, 기존 그림 속 인물의 상황표현을 과장했습니다. 저는 극단적인 표현과 유화의 입체감을 이용하여, 관람객들에게 있어서 보다 강한 메세지를 전달하고자 하였습니다. 굿즈도 많이 있으니 구경오세요!"

        helper.insertPicture(1, 9, "my work1", drawable_1, text)
        helper.insertPicture(1, 9, "my work2", drawable_1, text)
        helper.insertPicture(1, 9, "my work3", drawable_1, text)
        helper.insertPicture(1, 9, "my work4", drawable_1, text)
        helper.insertPicture(1, 9, "my work5", drawable_1, text)
        helper.insertPicture(1, 9, "my work6", drawable_1, text)
        helper.insertPicture(1, 9, "my work7", drawable_1, text)

    }

}