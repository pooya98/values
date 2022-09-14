package com.example.values.Fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import com.example.values.Adapter.Fragment_02_01_Post_Adapter
import com.example.values.R


class Fragment_02_01_Post : Fragment() {

    private val TAG = "MultiImageActivity"

    var adapter: Fragment_02_01_Post_Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__post, container, false)
        // Inflate the layout for this fragment

        return view
    }
}