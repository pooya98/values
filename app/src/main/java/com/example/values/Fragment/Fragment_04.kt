package com.example.values.Fragment

import android.content.ContentValues.TAG
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.values.Activity.MainActivity
import com.example.values.R
import com.example.values.databinding.Fragment04Binding


class Fragment_04 : Fragment(), View.OnClickListener {

    private var mBinding : Fragment04Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment04Binding.inflate(inflater, container,false)
        mBinding = binding

        val helper = (activity as MainActivity).helper

        val user = helper.selectUser((activity as MainActivity).USER_ID)

        mBinding?.profileImage2?.setImageBitmap(BitmapFactory.decodeByteArray(user.user_Image,0,user.user_Image!!.size))
        mBinding?.userName?.setText(user.user_name)


        mBinding?.myValuesButton?.setOnClickListener(this)
        mBinding?.eventButton?.setOnClickListener(this)

        return mBinding?.root
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

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.myValuesButton -> {
                findNavController().navigate(R.id.action_fragment_04_to_fragment_04_01)
            }
            R.id.eventButton -> {
                findNavController().navigate(R.id.action_fragment_04_to_fragment_04_02)
            }
        }
    }



}