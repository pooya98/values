package com.example.values.Fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_01_01_branding_Adapter
import com.example.values.Adapter.Fragment_01_01_illustration_Adapter
import com.example.values.R
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class Fragment_01_01 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_01_01, container, false)
        // Inflate the layout for this fragment

        val branding_viewpager = view.findViewById<ViewPager2>(R.id.fragment01_01_branding_viewpager)
        val illustration_viewpager = view.findViewById<ViewPager2>(R.id.fragment01_01_illustration_viewpager)
        val branding_indicator = view.findViewById<SpringDotsIndicator>(R.id.fragment01_01_branding_indicator)
        val illustration_indicator = view.findViewById<SpringDotsIndicator>(R.id.fragment01_01_illustration_indicator)
        //val main_spinner = view.findViewById<Spinner>(R.id.fragment_01_01_main_spinner)
        val linear_lagout_main_thumbnail = view.findViewById<LinearLayout>(R.id.LinearLayout_main_thumbnail)


        // viewPager 설정
        set_branding_viewPager(branding_viewpager)
        set_branding_viewPager_indicator(branding_viewpager, branding_indicator)
        set_illustration_viewPager(illustration_viewpager)
        set_illustration_viewPager_indicator(illustration_viewpager, illustration_indicator)

        //set_main_spinner(main_spinner)

        // 메인 썸네일 클릭 이벤트 리스터
        linear_lagout_main_thumbnail.setOnClickListener{
            (activity as MainActivity).navigateToFragment_01_01_ExhibitionDetail()
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

        branding_viewpager.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        branding_viewpager.offscreenPageLimit = 2

        branding_viewpager.adapter = Fragment_01_01_branding_Adapter(arrayListOf<Int>(
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item))


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

        illustration_viewpager.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        illustration_viewpager.offscreenPageLimit = 2

        illustration_viewpager.adapter = Fragment_01_01_branding_Adapter(arrayListOf<Int>(
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item,
            R.drawable.background_fragment_01_01_pg_item))


        illustration_viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        illustration_viewpager.setCurrentItem(2)
    }

    private fun set_illustration_viewPager_indicator(illustration_viewpager: ViewPager2, illustration_indicator: SpringDotsIndicator){
        illustration_indicator.attachTo(illustration_viewpager)
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