package com.example.values.Fragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.CodeScanner
import com.example.values.Activity.MainActivity
import com.example.values.Activity.QrActivity
import com.example.values.R

class Fragment_04_02_EventDetail : Fragment() {

    lateinit var codeScanner: CodeScanner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_04_02__event_detail, container, false)
        // Inflate the layout for this fragment

        val qr_scan_button = view.findViewById<Button>(R.id.qr_scan_button)


        qr_scan_button.setOnClickListener {
            (activity as MainActivity)?.StartQRActivity()
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("참여형 이벤트")
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideLogoAndShowBackButton("참여형 이벤트")
    }


}