package com.example.values.Fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.andrewjapar.rangedatepicker.CalendarPicker
import com.example.values.Activity.MainActivity
import com.example.values.R
import com.example.values.databinding.Fragment0201Binding
import com.example.values.databinding.Fragment02Binding
import java.text.SimpleDateFormat

class Fragment_02_01 : Fragment() {

    private var mBinding : Fragment0201Binding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_02_01, container, false)

        val linearLayout_pick_space = view.findViewById<LinearLayout>(R.id.LinearLayout_pick_space)
        val search_button = view.findViewById<Button>(R.id.fragment_02_01_Search_Button)

        val cal : CalendarPicker = view.findViewById(R.id.calendar_view)

        val pickedSpaceText = view.findViewById<TextView>(R.id.pickedSpaceText)

        val address = arguments?.getString("address")   //VALUES NAME:  ex)경산, 대전


        val sdf = SimpleDateFormat("MM/dd/yyyy")
        var selectStart : String? = null
        var selectEnd : String? = null

        if(address!=null){
            pickedSpaceText.setText("Values"+address)

        }



        cal.setOnRangeSelectedListener { startDate, endDate, startLabel, endLabel ->

            selectStart = sdf.format(startDate.time)
            selectEnd = sdf.format(endDate.time)

            Log.d("Fragment_02_01","start:"+sdf.format(startDate.time))
            Log.d("Fragment_02_01","end:"+sdf.format(endDate.time))


        }





        linearLayout_pick_space.setOnClickListener{
            (activity as MainActivity).navigateToFragment("fragment_02_01_SpacePick")
        }

        search_button.setOnClickListener {
            if(address != null){
//            (activity as MainActivity).navigateToFragment("fragment_02_01_ExhibitionAvailable",address!!,selectStart!!,selectEnd!!)

              val test = (activity as MainActivity).helper.selectExhibtions(1,"branding","2011", "2022").size
                Log.d("test",test.toString())
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

}