package com.example.values.Fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.BitmapFactory
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.andrewjapar.rangedatepicker.CalendarPicker
import com.example.values.Activity.MainActivity
import com.example.values.DTO.Exhibition_Data
import com.example.values.R
import com.example.values.databinding.Fragment0201Binding
import com.example.values.databinding.Fragment02Binding
import java.text.SimpleDateFormat
import java.util.*

class Fragment_02_01 : Fragment() {

    private var mBinding : Fragment0201Binding? = null
    private var selected_space_id : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 장소번호 초기화 (0은 '아직 선택하지 않음'을 뜻함)
        space_num_init()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_02_01, container, false)

        val linearLayout_pick_space = view.findViewById<LinearLayout>(R.id.fragment_02_01_space_pick)
        val linearLayout_space_selected = view.findViewById<LinearLayout>(R.id.fragment_02_01_space_selected)
        val search_button = view.findViewById<Button>(R.id.fragment_02_01_Search_Button)
        val cancel_button = view.findViewById<ImageButton>(R.id.fragment_02_01_button_cancel)

        val selected_space_image = view.findViewById<ImageView>(R.id.fragment_02_01_imageview_space_image)
        val selected_space_name = view.findViewById<TextView>(R.id.fragment_02_01_textview_space_name)
        val selected_space_address = view.findViewById<TextView>(R.id.fragment_02_01_textview_address)

        val cal : CalendarPicker = view.findViewById(R.id.calendar_view)

        selected_space_id = get_space_num()

        if(selected_space_id == 0){
            // 공간을 아직 선택하지 않은 경우 (space_num == 0)

            linearLayout_pick_space.visibility = View.VISIBLE
            linearLayout_space_selected.visibility = View.INVISIBLE
        }else{
            // 공간을 선택한 경우 (space_num == 공간의 ID)

            linearLayout_pick_space.visibility = View.INVISIBLE
            linearLayout_space_selected.visibility = View.VISIBLE

            val space_data = (context as MainActivity).helper.selectSingleSpace(selected_space_id)

            selected_space_image.setImageBitmap(BitmapFactory.decodeByteArray(space_data?.space_image,0,space_data?.space_image!!.size))
            selected_space_name.text = "VALUES" + space_data.space_name
            selected_space_address.text = space_data.region_name + " " + space_data.space_name

        }


        val sdf = SimpleDateFormat("MM/dd/yyyy")
        var selectStart : String? = null
        var selectEnd : String? = null


        cal.setOnRangeSelectedListener { startDate, endDate, startLabel, endLabel ->

            selectStart = sdf.format(startDate.time)
            selectEnd = sdf.format(endDate.time)

            Log.d("Fragment_02_01","start:"+sdf.format(startDate.time))
            Log.d("Fragment_02_01","end:"+sdf.format(endDate.time))

        }

        linearLayout_pick_space.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_02_01_SpacePick")
        }

        cancel_button.setOnClickListener {
            linearLayout_pick_space.visibility = View.VISIBLE
            linearLayout_space_selected.visibility = View.INVISIBLE

            space_num_init()
        }

        search_button.setOnClickListener {
            if (selected_space_id != 0) {

                Log.d("테스트", "진입완료")

                (activity as MainActivity).navigateToFragment(
                    "fragment_02_01_ExhibitionAvailable",
                    selectStart!!,
                    selectEnd!!,
                    selected_space_id!!,
                    "branding"
                )

                val bundle = Bundle()
                bundle.putString("selectStart",selectStart)
                bundle.putString("selectEnd",selectEnd)
                bundle.putString("brand","brand")
                bundle.putInt("space_id",selected_space_id)

                view.findNavController().navigate(R.id.action_fragment_02_01_to_fragment_02_01_ExhibitionAvailable, bundle)
            }
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


    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }


    private fun space_num_init() {
        val sharedPreference = context?.getSharedPreferences("space_pick", 0)
        val editor = sharedPreference?.edit()
        editor?.putString("space_id", 0.toString())
        editor?.apply()
    }

    private fun get_space_num() : Int{
        val sharedPreference = context?.getSharedPreferences("space_pick", 0)

        return sharedPreference?.getString("space_id", "").toString().toInt()
    }

}