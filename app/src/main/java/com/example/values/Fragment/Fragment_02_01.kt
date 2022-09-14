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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_02_01, container, false)

        val linearLayout_pick_space = view.findViewById<LinearLayout>(R.id.fragment_02_01_space_pick)
        val linearLayout_space_selected = view.findViewById<LinearLayout>(R.id.fragment_02_01_space_selected)
        val search_button = view.findViewById<Button>(R.id.fragment_02_01_Search_Button)

        val cal : CalendarPicker = view.findViewById(R.id.calendar_view)

        val address = arguments?.getString("address")   //VALUES NAME:  ex)경산, 대전
        val spaceId = arguments?.getInt("spaceId")

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
            view.findNavController().navigate(R.id.action_fragment_02_to_fragment_02_01_SpacePick)
        }

        search_button.setOnClickListener {
            if (address != null) {

                val exhibitionList =
                    (activity as MainActivity).helper.selectExhibtions(1, "branding")

                Log.d(
                    "checkList:",
                    compareDatetime(exhibitionList, selectStart!!, selectEnd!!).size.toString()
                )


                (activity as MainActivity).navigateToFragment(
                    "fragment_02_01_ExhibitionAvailable",
                    selectStart!!,
                    selectEnd!!,
                    spaceId!!,
                    "branding"
                )


            }

        }

        return view
    }


    fun compareDatetime(list:MutableList<Exhibition_Data>, c_startDate:String,c_endDate:String):MutableList<Exhibition_Data>
    {

        val sdf = SimpleDateFormat("MM/dd/yyyy")



        val check_startDate: Date = sdf.parse(c_startDate)
        val check_endDate : Date = sdf.parse(c_endDate)
        var size = list.size

        Log.d(" size: ",size.toString() )
        var count = 0
        var tempList : MutableList<Exhibition_Data>
        while(count<size)
        {
            Log.d("count: ",count.toString())

            val ex_startDate: Date = sdf.parse(list[count].exhibition_startDate)
            val ex_endDate: Date = sdf.parse(list[count].exhibition_endDate)

            Log.d("exStart:",ex_startDate.toString())
            Log.d("exEnd:",ex_endDate.toString())


            when {

            ex_endDate.before(check_startDate) || ex_startDate.after(check_endDate) -> {

                list.removeAt(count)
                count--
                size--

              }

            }
            count++
        }


        return list



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