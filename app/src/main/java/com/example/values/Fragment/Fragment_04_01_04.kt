package com.example.values.Fragment

import android.app.ActionBar
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.values.Activity.MainActivity

import com.example.values.Adapter.Fragment_04_01_02_badges_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio2_Adapter
import com.example.values.Adapter.Fragment_04_01_04_portfolio_Adapter
import com.example.values.DTO.Fragment_04_01_02_badges_Data
import com.example.values.DTO.Fragment_04_01_04_portfolio_Data
import com.example.values.R
import com.example.values.databinding.Fragment040104Binding


class Fragment_04_01_04 : Fragment() ,View.OnClickListener{



    private var mBinding : Fragment040104Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment040104Binding.inflate(inflater, container,false)
        mBinding = binding
        var recyclerView = mBinding?.portfolioRecycler
        var recyclerView2 = mBinding?.portfolioRecycler2

        var check2 = mBinding?.pfCheck2
        var check3 = mBinding?.pfCheck3



        var profileImage = mBinding?.portfolioProfileImage
        var profileUserName = mBinding?.portfolioUserName

        var goodsCountText = mBinding?.sellingGoodsCount
        var exhibitionCountText = mBinding?.allExhibitionCounts

        var user = (activity as MainActivity).helper.selectUser((activity as MainActivity).USER_ID)
        var user_image = user.user_Image
        var user_name = user.user_name


        val author_id = arguments?.getString("author_id")

        if(author_id!=null){


            check2?.visibility = View.INVISIBLE
            check3?.visibility = View.INVISIBLE

        }else{

            check2?.visibility = View.VISIBLE
            check3?.visibility = View.VISIBLE

        }



        profileImage?.setImageBitmap(BitmapFactory.decodeByteArray(user_image,0,user_image!!.size))
        profileUserName?.setText("'"+user_name+"'")

        var userGoodsList = (activity as MainActivity).helper.selectGoodsByAuthor((activity as MainActivity).USER_ID)
        var pictureList = (activity as MainActivity).helper.selectPictureList_byUserId((activity as MainActivity).USER_ID)

        goodsCountText?.setText(userGoodsList.size.toString())
        exhibitionCountText?.setText(pictureList.size.toString())

        val pictureAdapter = Fragment_04_01_04_portfolio_Adapter(userGoodsList,(activity as MainActivity))
        val pictureAdapter2 = Fragment_04_01_04_portfolio2_Adapter(pictureList,(activity as MainActivity))
        recyclerView?.adapter = pictureAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        recyclerView2?.adapter = pictureAdapter2
        recyclerView2?.layoutManager = GridLayoutManager(activity,2)



        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null   //메모리에서 다시 날려주기위함
        super.onDestroyView()
    }



    override fun onClick(v: View?) {

        when(v?.id){

        }
    }





}