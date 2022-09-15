package com.example.values.DTO

data class Picture_Data(

    var picture_id:Int,
    var picture_image:ByteArray?,
    var picture_name:String?,
    var picture_detail:String,
    var author_id:Int,
    var author_name:String,
    var exhibition_id: Int

)
