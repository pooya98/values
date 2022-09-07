package com.example.values.DTO

data class Goods_Data(


    var goods_price:String,
    var goods_name:String,
    var goods_image:ByteArray?,
    var goods_type:Int,   //1이 Branding, //2가 Illustration
    var author_id:Int


)
