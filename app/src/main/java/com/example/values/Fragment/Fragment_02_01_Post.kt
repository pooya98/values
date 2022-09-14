package com.example.values.Fragment

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Nullable
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import com.example.values.Activity.DB_NAME
import com.example.values.Activity.DB_VERSION
import com.example.values.Activity.MainActivity
import com.example.values.Activity.SqliteHelper
import com.example.values.Adapter.Fragment_02_01_Post_Adapter
import com.example.values.DTO.Picture_Data
import com.example.values.R

class Fragment_02_01_Post : Fragment() {

    private val imageUriList: Array<Uri>? = null

    private val TAG = "MultiImageActivity"
    var uriList: ArrayList<Uri> = ArrayList() // 이미지의 uri를 담을 ArrayList 객체


    var imageView_picture_image : ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_02_01__post, container, false)


        var editText_author_id = view.findViewById<EditText>(R.id.post_author_name)
        var editText_picture_name = view.findViewById<EditText>(R.id.post_picture_name)
        var editText_picture_detail = view.findViewById<EditText>(R.id.post_picture_detail)

        var button_image_upload = view.findViewById<LinearLayout>(R.id.fragment_02_01_post_button_upload_image)
        imageView_picture_image = view.findViewById<ImageView>(R.id.post_picture_image)
        var button_post = view.findViewById<Button>(R.id.post_button_post)

        val exhibition_id = arguments?.getInt("exhibition_id")


        button_image_upload.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = MediaStore.Images.Media.CONTENT_TYPE
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false) // 다중 이미지를 가져올 수 있도록 세팅

            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent, 2000)
        }


        button_post.setOnClickListener {
            var picture_id = 4
            var author_id = editText_author_id.text.toString().toInt()
            var picture_name = editText_picture_name.text.toString()
            var picture_detail = editText_picture_detail.text.toString()
            var exhibition_id = exhibition_id

            val pic_image = imageView_picture_image?.drawable

            if (exhibition_id != null) {
                (activity as MainActivity).helper.insertPicture(
                    picture_id,
                    exhibition_id,
                    author_id,
                    picture_name,
                    pic_image,
                    picture_detail
                )

                view.findNavController().navigate(R.id.action_fragment_02_01_Post_to_fragment_02_01_PostComplete)
            }
        }

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
        } else {
            val imageUri = data.data
            imageView_picture_image?.setImageURI(imageUri)// 이미지를 하나라도 선택한 경우
            if (data.clipData == null) {     // 이미지를 하나만 선택한 경우
                Log.e("single choice: ", data.data.toString())
                val imageUri = data.data

                if (imageUri != null) {
                    uriList.add(imageUri)
                    imageView_picture_image?.setImageURI(imageUri)
                }

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

                }
            }
        }
    }

}