package com.example.values.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.example.values.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_01.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_01 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_01, container, false)

        val topMenuButtons = view.findViewById<RadioGroup>(R.id.fragment01_radioGroup)

        topMenuButtons.setOnCheckedChangeListener{ radioGroup, checkedId ->
            when(checkedId){
                R.id.fragment01_radio1 -> {
                    childFragmentManager.beginTransaction().replace(R.id.fragment01_FrameLayout, Fragment_01_01()).commit()
                }

                R.id.fragment01_radio2 -> {

                }

                R.id.fragment01_radio3 -> {

                }

                R.id.fragment01_radio4 -> {

                }
            }
        }

        childFragmentManager.beginTransaction().replace(R.id.fragment01_FrameLayout, Fragment_01_01()).commit()
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_01.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_01().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}