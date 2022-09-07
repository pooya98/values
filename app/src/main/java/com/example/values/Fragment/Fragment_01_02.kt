package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_02_goods_Adapter
import com.example.values.DTO.Goods_Data
import com.example.values.R
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class Fragment_01_02 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_01_02, container, false)
        // Inflate the layout for this fragment

        val branding_viewpager = view.findViewById<ViewPager2>(R.id.fragment01_02_branding_viewpager)
        val illustration_viewpager = view.findViewById<ViewPager2>(R.id.fragment01_02_illustration_viewpager)
        val branding_indicator = view.findViewById<SpringDotsIndicator>(R.id.fragment01_02_branding_indicator)
        val illustration_indicator = view.findViewById<SpringDotsIndicator>(R.id.fragment01_02_illustration_indicator)
        val linear_lagout_main_thumbnail = view.findViewById<LinearLayout>(R.id.fragment_01_02_LinearLayout_main_thumbnail)

        set_branding_viewPager(branding_viewpager)
        set_branding_viewPager_indicator(branding_viewpager, branding_indicator)
        set_illustration_viewPager(illustration_viewpager)
        set_illustration_viewPager_indicator(illustration_viewpager, illustration_indicator)

        linear_lagout_main_thumbnail.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_01_02_Shop")
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

    private fun set_branding_viewPager(branding_viewpager: ViewPager2){
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.

        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        val brandinglist : ArrayList<Goods_Data> = (activity as MainActivity).helper.selectGoods(1)

//        var transform = CompositePageTransformer()
//        transform.addTransformer

        branding_viewpager.setPageTransformer { page, position ->



            var v = 1-Math.abs(position)

//            if(v.equals(1)){
//                 여기서 함수작성하면 될듯.
//            }

            page.translationX = position * -offsetPx//앞으로 나오게하는 코드 맞냐 승우야?

            page.scaleY = 0.85f + v * 0.15f   //페이지들 사이즈 조정 뷰.
            page.scaleX = 0.85f + v * 0.15f

            page.alpha = 0.6f + v * 0.4f   //흐리게 만들기.
        }

        branding_viewpager.offscreenPageLimit = 2

        branding_viewpager.adapter = Fragment_01_02_goods_Adapter(brandinglist,activity as MainActivity)


        branding_viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        branding_viewpager.setCurrentItem(2)
    }

    private fun set_branding_viewPager_indicator(branding_viewpager: ViewPager2, branding_indicator: SpringDotsIndicator){
        branding_indicator.attachTo(branding_viewpager)
    }

    private fun set_illustration_viewPager(illustration_viewpager: ViewPager2){
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        val illustList : ArrayList<Goods_Data> = (activity as MainActivity).helper.selectGoods(2)

        illustration_viewpager.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        illustration_viewpager.offscreenPageLimit = 2

        illustration_viewpager.adapter = Fragment_01_02_goods_Adapter(illustList,activity as MainActivity)


        illustration_viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        illustration_viewpager.setCurrentItem(2)
    }

    private fun set_illustration_viewPager_indicator(illustration_viewpager: ViewPager2, illustration_indicator: SpringDotsIndicator){
        illustration_indicator.attachTo(illustration_viewpager)
    }
}