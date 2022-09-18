package com.example.values.Fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.values.Activity.MainActivity
import com.example.values.R

class Fragment_01_01_Purchase : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_01_01__purchase, container, false)

        val user_id = arguments?.getInt("user_id")
        val exhibition_id = arguments?.getInt("exhibition_id")
        val picture_id = arguments?.getInt("picture_id")

        Log.d("pic_id", picture_id.toString() + exhibition_id.toString() + user_id.toString())


        val picture_image = view.findViewById<ImageView>(R.id.purchase_picture_image)
        val picture_name = view.findViewById<TextView>(R.id.purchase_picture_name)
        val picture_detail = view.findViewById<TextView>(R.id.purchase_picture_detail)
        val time_space_type = view.findViewById<TextView>(R.id.purchase_time_space_type)

        val pic_data = (activity as MainActivity).helper.selectPicture(picture_id!!)
        val exh_data = (activity as MainActivity).helper.selectSingleExhibition(exhibition_id!!)

        val button_pay01 = view.findViewById<LinearLayout>(R.id.purchase_pay01)
        val button_pay02 = view.findViewById<LinearLayout>(R.id.purchase_pay02)
        val button_pay03 = view.findViewById<LinearLayout>(R.id.purchase_pay03)

        picture_image.setImageBitmap(BitmapFactory.decodeByteArray(pic_data?.picture_image,0, pic_data?.picture_image!!.size))
        picture_name.setText(pic_data?.picture_name)
        picture_detail.setText(pic_data?.picture_detail)

        time_space_type.setText(exh_data.exhibition_startDate.substring(0 until 5) + " - " + exh_data.exhibition_endDate.substring(0 until 5)  + " / 6:00PM 철거 " + exh_data.position_name + " - [" + exh_data.exhibition_type + "]")

        button_pay01.setOnClickListener {
            (activity as MainActivity).helper.insertReservation(user_id!!, exhibition_id)
            findNavController().popBackStack()
            Toast.makeText(activity,"상품 구매가 완료되었습니다!",Toast.LENGTH_SHORT).show()
            Log.d("구매완료", "구매완료")
        }
        button_pay02.setOnClickListener {
            (activity as MainActivity).helper.insertReservation(user_id!!, exhibition_id)
            findNavController().popBackStack()
            Toast.makeText(activity,"상품 구매가 완료되었습니다!",Toast.LENGTH_SHORT).show()
            Log.d("구매완료", "구매완료")
        }
        button_pay03.setOnClickListener {
            (activity as MainActivity).helper.insertReservation(user_id!!, exhibition_id)
            findNavController().popBackStack()
            Toast.makeText(activity,"상품 구매가 완료되었습니다!",Toast.LENGTH_SHORT).show()
            Log.d("구매완료", "구매완료")
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("구매하기")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("구매하기")
    }
}