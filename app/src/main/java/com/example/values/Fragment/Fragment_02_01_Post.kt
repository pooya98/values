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

    private val imageUriList: Array<Uri>? = null

    private val TAG = "MultiImageActivity"
    var uriList: ArrayList<Uri> = ArrayList() // 이미지의 uri를 담을 ArrayList 객체


    var recyclerView : RecyclerView? = null
    var adapter: Fragment_02_01_Post_Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__post, container, false)
        // Inflate the layout for this fragment

        var button = view.findViewById<Button>(R.id.getImage)

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = MediaStore.Images.Media.CONTENT_TYPE
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true) // 다중 이미지를 가져올 수 있도록 세팅

            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent, 2000)
        }

        recyclerView = view.findViewById(R.id.recyclerView_post)
        return view
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {   // 어떤 이미지도 선택하지 않은 경우
            Toast.makeText(
                ApplicationProvider.getApplicationContext<Context>(),
                "이미지를 선택하지 않았습니다.",
                Toast.LENGTH_LONG
            ).show()
        } else {   // 이미지를 하나라도 선택한 경우
            if (data.clipData == null) {     // 이미지를 하나만 선택한 경우
                Log.e("single choice: ", data.data.toString())
                val imageUri = data.data

                if (imageUri != null) {
                    uriList.add(imageUri)
                }

                adapter = Fragment_02_01_Post_Adapter(uriList, ApplicationProvider.getApplicationContext())
                recyclerView?.setAdapter(adapter)
                recyclerView?.setLayoutManager(
                    LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        true
                    )
                )
            } else {      // 이미지를 여러장 선택한 경우
                val clipData = data.clipData
                Log.e("clipData", clipData!!.itemCount.toString())
                if (clipData.itemCount > 10) {   // 선택한 이미지가 11장 이상인 경우
                    Toast.makeText(
                        ApplicationProvider.getApplicationContext<Context>(),
                        "사진은 10장까지 선택 가능합니다.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {   // 선택한 이미지가 1장 이상 10장 이하인 경우
                    Log.e(TAG, "multiple choice")
                    for (i in 0 until clipData.itemCount) {
                        val imageUri = clipData.getItemAt(i).uri // 선택한 이미지들의 uri를 가져온다.
                        try {
                            uriList.add(imageUri) //uri를 list에 담는다.

                            for(i in uriList)
                                print("$i ")

                        } catch (e: Exception) {
                            Log.e(TAG, "File select error", e)
                        }
                    }

                    adapter = Fragment_02_01_Post_Adapter(uriList, context)
                    recyclerView?.setAdapter(adapter) // 리사이클러뷰에 어댑터 세팅
                    recyclerView?.setLayoutManager(
                        LinearLayoutManager(
                            context,
                            LinearLayoutManager.HORIZONTAL,
                            true
                        )
                    ) // 리사이클러뷰 수평 스크롤 적용
                }
            }
        }
    }

}