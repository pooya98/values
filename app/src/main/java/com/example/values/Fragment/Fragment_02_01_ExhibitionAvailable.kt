package com.example.values.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity
import com.example.values.Adapter.Fragment_02_01_Available_Adapter
import com.example.values.Adapter.Fragment_02_01_Cities_Adapter
import com.example.values.Adapter.Fragment_02_01_Space_Adapter
import com.example.values.DTO.Exhibition_Data
import com.example.values.R
import java.text.SimpleDateFormat
import java.util.*

class Fragment_02_01_ExhibitionAvailable : Fragment() {

    lateinit var fragment_02_01_Available_Adapter: Fragment_02_01_Available_Adapter

    val datas = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__exhibition_available, container, false)
        // Inflate the layout for this fragment

        val recyclerview_available = view.findViewById<RecyclerView>(R.id.fragment_02_01_ExhibitionAvailable_list)



        val selectStartDate = arguments?.getString("selectStart")
        val selectEndDate = arguments?.getString("selectEnd")
        val space_id = arguments?.getInt("space_id")
        val brand = arguments?.getString("brand")




        val exhibitionList = (activity as MainActivity).helper.selectExhibtions(space_id!!,"branding")

        val finalList = compareDatetime(exhibitionList,selectStartDate!!,selectEndDate!!)

        Log.d("selectStartDate:", selectStartDate.toString())


        initRecycler_available(recyclerview_available,finalList)




        return view
    }




    private fun initRecycler_available(rv_list: RecyclerView,finalList:MutableList<Exhibition_Data>) {
        fragment_02_01_Available_Adapter = Fragment_02_01_Available_Adapter(this)
        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = fragment_02_01_Available_Adapter

         fragment_02_01_Available_Adapter.datas = finalList

         fragment_02_01_Available_Adapter.notifyDataSetChanged()


    }


    fun compareDatetime(list:MutableList<Exhibition_Data>, c_startDate:String, c_endDate:String):MutableList<Exhibition_Data>
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

}