package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_02_goods_Adapter
import com.example.values.Adapter.Fragment_01_01_picture_Adapter
import com.example.values.DTO.Goods_Data
import com.example.values.DTO.Picture_Data
import com.example.values.R
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class Fragment_01_01 : Fragment() {

    var branding_viewpager : ViewPager2? = null
    var illustration_viewpager : ViewPager2? = null
    var branding_indicator : SpringDotsIndicator? = null
    var illustration_indicator : SpringDotsIndicator? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_01_01, container, false)
        // Inflate the layout for this fragment

        branding_viewpager = view.findViewById<ViewPager2>(R.id.fragment01_01_branding_viewpager)
        illustration_viewpager = view.findViewById<ViewPager2>(R.id.fragment01_01_illustration_viewpager)
        branding_indicator = view.findViewById<SpringDotsIndicator>(R.id.fragment01_01_branding_indicator)
        illustration_indicator = view.findViewById<SpringDotsIndicator>(R.id.fragment01_01_illustration_indicator)
        val main_spinner = view.findViewById<Spinner>(R.id.fragment_01_01_main_spinner)
        val linear_lagout_main_thumbnail = view.findViewById<LinearLayout>(R.id.LinearLayout_main_thumbnail)

        val filter_button = view.findViewById<LinearLayout>(R.id.fragment_01_01_filter_button)
        val search_button = view.findViewById<ImageButton>(R.id.fragment_01_01_search_button)


        // viewPager 설정
        set_branding_viewPager()
        set_branding_viewPager_indicator()
        set_illustration_viewPager()
        set_illustration_viewPager_indicator()

        set_main_spinner(main_spinner)

        // 메인 썸네일 클릭 이벤트 리스터
        linear_lagout_main_thumbnail.setOnClickListener{
            val bundle = Bundle()
            bundle.putInt("picture_id", 1)
            (context as MainActivity).navigateToFragment("fragment_01_01_ExhibitionDetail", bundle)
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideBackButtonAndShowLogo()
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideBackButtonAndShowLogo()
    }

    override fun onPause() {
        super.onPause()
        Log.d("테스트", "onPause()")
    }


    private fun set_branding_viewPager(){

        Log.d("viewpage 테스트", "set_branding_viewPager 호출")
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        branding_viewpager?.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        branding_viewpager?.setPageTransformer { page, position ->

            var v = 1-Math.abs(position)

            page.translationX = position * -offsetPx//앞으로 나오게하는 코드 맞냐 승우야?
            page.scaleY = 0.85f + v * 0.15f   //페이지들 사이즈 조정 뷰.
            page.scaleX = 0.85f + v * 0.15f
            page.alpha = 0.6f + v * 0.4f   //흐리게 만들기.
        }

        val pictureList : ArrayList<Picture_Data> = (activity as MainActivity).helper.selectPictureList_latest()
        branding_viewpager?.adapter = Fragment_01_01_picture_Adapter(pictureList, requireContext())

        branding_viewpager?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        branding_viewpager?.offscreenPageLimit = 7
        branding_viewpager?.setCurrentItem(4)
    }

    private fun set_branding_viewPager_indicator(){
        branding_indicator?.attachTo(branding_viewpager!!)
    }

    private fun set_illustration_viewPager() {
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        illustration_viewpager?.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        illustration_viewpager?.setPageTransformer { page, position ->

            var v = 1-Math.abs(position)

            page.translationX = position * -offsetPx//앞으로 나오게하는 코드 맞냐 승우야?
            page.scaleY = 0.85f + v * 0.15f   //페이지들 사이즈 조정 뷰.
            page.scaleX = 0.85f + v * 0.15f
            page.alpha = 0.6f + v * 0.4f   //흐리게 만들기.
        }

        val pictureList : ArrayList<Picture_Data> = (activity as MainActivity).helper.selectPictureList_latest()
        illustration_viewpager?.adapter = Fragment_01_01_picture_Adapter(pictureList, activity as MainActivity)

        illustration_viewpager?.offscreenPageLimit = 2
        illustration_viewpager?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        illustration_viewpager?.setCurrentItem(4)
    }

    private fun set_illustration_viewPager_indicator(){
        illustration_indicator?.attachTo(illustration_viewpager!!)
    }

    private fun set_main_spinner(main_spinner: Spinner){
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_list_fragment_01_01,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            main_spinner.adapter = adapter
        }
    }
}