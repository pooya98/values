package com.example.values.Fragment

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Picture_Data
import com.example.values.DTO.User_Data
import com.example.values.R

class Fragment_01_01_ExhibitionDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_01_01__exhibition_detail, container, false)

        // Inflate the layout for this fragment

        val author_image = view.findViewById<ImageView>(R.id.fragment_01_01_ExhibitionDetail_author_image)
        val author_name = view.findViewById<TextView>(R.id.fragment_01_01_ExhibitionDetail_author_name)
        val picture_image = view.findViewById<ImageView>(R.id.fragment_01_01_ExhibitionDetail_picture_image)
        val picture_name = view.findViewById<TextView>(R.id.fragment_01_01_ExhibitionDetail_picture_name)
        val picture_detail = view.findViewById<TextView>(R.id.fragment_01_01_ExhibitionDetail_picture_detail)

        val subscribe_button = view.findViewById<Button>(R.id.fragment_01_01_ExhibitionDetail_button_subscribe)
        val purchase_button = view.findViewById<Button>(R.id.fragment_01_01_ExhibitionDetail_button_purchase)

        val picture_id = arguments?.getInt("picture_id")

        Log.d("pic_id 확인", picture_id.toString())

        val picture_data : Picture_Data? = (activity as MainActivity).helper.selectPicture(picture_id!!)
        val author_data : User_Data? = (activity as MainActivity).helper.selectUser(picture_data?.author_id!!)

        author_image.setImageBitmap(BitmapFactory.decodeByteArray(author_data?.user_Image,0, author_data?.user_Image!!.size))
        author_name.setText(author_data.user_name)
        picture_image.setImageBitmap(BitmapFactory.decodeByteArray(picture_data.picture_image,0, picture_data.picture_image!!.size))
        picture_name.setText(picture_data.picture_name)
        picture_detail.setText(picture_data.picture_detail)

        author_image.setOnClickListener{
            Log.d("check:","ClickText")
            (activity as MainActivity).navigateToFragment("fragment_04_01_04", picture_data.author_id )
        }

        subscribe_button.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_01_01_Subscribe")
        }

        purchase_button.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_01_01_Purchase")
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("진행중인 전시")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("진행중인 전시")
    }

}