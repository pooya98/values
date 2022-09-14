package com.example.values.Activity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Space
import com.example.values.DTO.*
import java.io.ByteArrayOutputStream


class SqliteHelper(context: MainActivity, name:String, version:Int) : SQLiteOpenHelper(context,name,null,version){
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table user (u_id integer primary key, name text, image blob)")
        db?.execSQL("create table space (s_id integer primary key, region text, s_name text, image blob)")
        db?.execSQL("create table position (p_id integer primary key,p_name text,space_id integer, constraint space_id_fk foreign key(space_id) references space(s_id))")
        db?.execSQL("create table goods (g_id integer primary key, author_id integer, name text, detail text, price text, image blob,type integer, constraint author_id_fk foreign key(author_id) references user(u_id))")
        db?.execSQL("create table exhibition (e_id integer primary key, position_id integer, start_date text, end_date text,type text, constraint position_id_fk foreign key(position_id) references position(p_id))")
        db?.execSQL("create table picture (p_id integer primary key, author_id integer, exhibition_id integer, name text, detail text, image text, constraint author_id_fk foreign key(author_id) references user(u_id), constraint exhibition_id_fk foreign key(exhibition_id) references exhibition(e_id))")
        db?.execSQL("create table reservation (r_id integer primary key, user_id integer, exhibition_id integer, constraint user_id_fk foreign key(user_id) references user(u_id), constraint exhibition_id_fk foreign key(exhibition_id) references exhibition(e_id))")

//        db?.execSQL("insert into user (u_id, name, image) values (1, '강승우', 'NULL')")
//        db?.execSQL("insert into user (u_id, name, image) values (2, '금윤수', 'NULL')")
//        db?.execSQL("insert into user (u_id, name, image) values (3, '김대희', 'NULL')")


//        val umzziImage = ContentValues()
//        umzziImage.put("image",drawableToByteArray(R.drawable.irene))
//        val n : Int = R.drawable.irene
//        db?.execSQL("insert into user (u_id, name, image) values (4, 'UMZZI', n)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS reservation")

        db?.execSQL("DROP TABLE IF EXISTS picture")
        db?.execSQL("DROP TABLE IF EXISTS exhibition")
        db?.execSQL("DROP TABLE IF EXISTS position")
        db?.execSQL("DROP TABLE IF EXISTS space")
        db?.execSQL("DROP TABLE IF EXISTS picture")


        db?.execSQL("DROP TABLE IF EXISTS goods")
        db?.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
        //테이블에 변경사항이 있을 경우 호출됨.
        //SqliteHelper()의 생성자를 호출할 때 기존 데이터베이스와 version을 비교해서 더 높으면
        //호출된다.



    }


    override fun onConfigure(db: SQLiteDatabase?) {

        db?.setForeignKeyConstraintsEnabled(true)  //외래키를 강제
//        db?.disableWriteAheadLogging(); //WAL 해제. Write-ahead logging , 트랜잭션이 일어나기 전 로그를 미리 기록, undo,redo할 수 있도록 함,

        super.onConfigure(db)
    }

    fun insertPositions(id:Int,name:String,space_id:Int){

        val values = ContentValues()
        values.put("p_id",id)
        values.put("p_name",name)
        values.put("space_id",space_id)
        val wd = writableDatabase
        wd.insert("position",null,values)
        wd.close()


    }




    @SuppressLint("Range")   //Frgment_02_01_SpacePick
    fun selectExhibtions(spaceId:Int, type: String): MutableList<Exhibition_Data> {

        val list = mutableListOf<Exhibition_Data>()
        // db 가져오기
        val select = "select * from exhibition, space, position where (space.s_id = position.space_id) and (space.s_id ="+spaceId+") and (position.p_id = exhibition.position_id) and (exhibition.type=\""+type+"\")"
        val select2 = "select * from position inner join space on position.space_id = space.s_id inner join exhibition on position.p_id = exhibition.position_id"



        val rd = readableDatabase


        val cursor = rd.rawQuery(select,null)
        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.


        while(cursor.moveToNext()){
            val exhibitionId:Int = cursor.getInt(cursor.getColumnIndex("e_id"))
            val startDate:String = cursor.getString(cursor.getColumnIndex("start_date"))
            val endDate:String = cursor.getString(cursor.getColumnIndex("start_date"))
            val positionName:String = cursor.getString(cursor.getColumnIndex("p_name"))
            val spaceName:String = cursor.getString(cursor.getColumnIndex("s_name"))
            val exhibitionType:String = cursor.getString(cursor.getColumnIndex("type"))






            list.add(Exhibition_Data(exhibitionId, startDate, endDate,positionName,spaceName,exhibitionType ))

        }

        cursor.close()
        rd.close()

        return list
    }


    fun insertExhibitions(id:Int,positionId:Int,start_date:String,end_date:String,type:String){

        val values = ContentValues()
        values.put("e_id",id)
        values.put("position_Id",positionId)
        values.put("start_date",start_date)
        values.put("end_date",end_date)
        values.put("type",type)
        val wd = writableDatabase
        wd.insert("exhibition",null,values)
        wd.close()


    }




//    @SuppressLint("Range")
//    fun selectAddressBySpaceId(spaceId:Int): Fragment_02_01_Address_Data {
//
//        val list = mutableListOf<Fragment_02_01_Address_Data>()
//        // db 가져오기
//        val select = "select * from space where s_id="+spaceId
//
//        val rd = readableDatabase
//
//
//        val cursor = rd.rawQuery(select,null)
//        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.
//
//        while(cursor.moveToNext()){
//            val position = cursor.getString(cursor.getColumnIndex("position"))
//            val image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?:null
//            val address:String = cursor.getString(cursor.getColumnIndex("address"))
//            val space_id:Int = cursor.getInt(cursor.getColumnIndex("s_id"))
//
//
//
////            list.add(Fragment_02_01_Address_Data(address,position,image,space_id))
//        }
//
//        cursor.close()
//        rd.close()
//
//        return list[0]
//    }




    @SuppressLint("Range")   //Frgment_02_01_SpacePick
    fun selectAddressByRegion(spaceRegion:String): MutableList<Fragment_02_01_Address_Data> {

        val list = mutableListOf<Fragment_02_01_Address_Data>()
        // db 가져오기
        val select = "select s_name,image,s_id from space where region=\'${spaceRegion}\'"

        val rd = readableDatabase


        val cursor = rd.rawQuery(select,null)
        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.

        while(cursor.moveToNext()){
            val image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?:null
            val address:String = cursor.getString(cursor.getColumnIndex("s_name"))
            val space_id:Int = cursor.getInt(cursor.getColumnIndex("s_id"))



            list.add(Fragment_02_01_Address_Data(address,image,space_id))
        }

        cursor.close()
        rd.close()

        return list
    }


    fun insertSpace(id:Int,spaceRegion:String,name:String,drawable:Drawable?){

        val values = ContentValues()
        values.put("s_id",id)
        values.put("region",spaceRegion)
        values.put("s_name",name)
        values.put("image",drawableToByteArray(drawable!!))
        val wd = writableDatabase
        wd.insert("space",null,values)
        wd.close()


    }



    fun insertGoods(id:Int,author_id:Int,goods_name:String,goods_price:String,goodstype: Int,drawable:Drawable?){

        val values = ContentValues()
        values.put("g_id",id)
        values.put("author_id",author_id)
        values.put("name",goods_name)
        values.put("price",goods_price)
        values.put("image",drawableToByteArray(drawable!!))
        values.put("type",goodstype)
        val wd = writableDatabase
        wd.insert("goods",null,values)
        wd.close()


    }


    //작가에 따른 굿즈들 조회 함수.
    @SuppressLint("Range")
    fun selectGoodsByAuthor(author_id:Int): ArrayList<Goods_Data> {

        val list = arrayListOf<Goods_Data>()
        // db 가져오기
        val select = "select * from goods where author_id="+author_id

        val rd = readableDatabase

        var goods : User_Data? = null

        val cursor = rd.rawQuery(select,null)
        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.

        while(cursor.moveToNext()){
            val userName = cursor.getString(cursor.getColumnIndex("name"))
            val image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?:null

            val author_id:Int = cursor.getInt(cursor.getColumnIndex("author_id"))
            val goods_name:String = cursor.getString(cursor.getColumnIndex("name"))
            val goods_detail:String? = cursor.getString(cursor.getColumnIndex("detail"))
            val goods_price:String = cursor.getString(cursor.getColumnIndex("price"))
            val goods_image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image"))?:null


            val goods_type:Int  = cursor.getInt(cursor.getColumnIndex("type"))

            list.add(Goods_Data(goods_price,goods_name,goods_image,goods_type,author_id))
        }

        cursor.close()
        rd.close()

        return list
    }



    //type에 따른 굿즈 조회 함수.
    @SuppressLint("Range")
    fun selectGoods(goodstype:Int): ArrayList<Goods_Data> {

        val list = arrayListOf<Goods_Data>()
        // db 가져오기
        val select = "select * from goods where type="+goodstype

        val rd = readableDatabase

        var goods : User_Data? = null

        val cursor = rd.rawQuery(select,null)
        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.

        while(cursor.moveToNext()){
            val userName = cursor.getString(cursor.getColumnIndex("name"))
            val image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?:null

            val author_id:Int = cursor.getInt(cursor.getColumnIndex("author_id"))
            val goods_name:String = cursor.getString(cursor.getColumnIndex("name"))
            val goods_detail:String? = cursor.getString(cursor.getColumnIndex("detail"))
            val goods_price:String = cursor.getString(cursor.getColumnIndex("price"))
            val goods_image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image"))?:null


            val goods_type:Int  = cursor.getInt(cursor.getColumnIndex("type"))

            list.add(Goods_Data(goods_price,goods_name,goods_image,goods_type,author_id))
        }

        cursor.close()
        rd.close()

        return list
    }



    fun insertUser(id:Int,name:String,drawable:Drawable?){

        val values = ContentValues()
        values.put("u_id",id)
        values.put("name",name)
        values.put("image",drawableToByteArray(drawable!!))
        val wd = writableDatabase
        wd.insert("user",null,values)
        wd.close()


    }








    //use id 로 사용자 조회 함수.
    @SuppressLint("Range")
    fun selectUser(user_id:Int):User_Data{


        // db 가져오기
        val select = "select * from user where u_id="+user_id

        val rd = readableDatabase

        var user : User_Data? = null

        val cursor = rd.rawQuery(select,null)
        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.

        while(cursor.moveToNext()){
            val userName = cursor.getString(cursor.getColumnIndex("name"))
            val image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?:null

            user = User_Data(userName, image)
        }

        cursor.close()
        rd.close()

        return user!!
    }


    // 데이터 조회함수

    @SuppressLint("Range")
    fun selectSingleSpace(space_id: Int): Space_Data? {

        var space_data: Space_Data? = null

        val select = "select * from space where s_id = " + space_id

        val rd = readableDatabase
        val cursor = rd.rawQuery(select,null)  //execSQL처럼 쿼리문을 실행하나 rawQuery는 cursor타입의 반환값을 가짐. cursor는 일종의 리스트.
        while(cursor.moveToNext()){
            val s_id = cursor.getInt(cursor.getColumnIndex("s_id"))
            val space_name = cursor.getString(cursor.getColumnIndex("s_name"))
            val space_image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?:null
            val region_name = cursor.getString(cursor.getColumnIndex("region"))

           space_data = Space_Data(s_id, space_name, region_name, space_image)
        }

        cursor.close()
        rd.close()

        return space_data
    }

    fun insertPicture(id: Int, exhibition_id: Int, author_id: Int, pic_name: String, pic_image: Drawable?, pic_detail: String){

        val values = ContentValues()
        values.put("p_id",id)
        values.put("author_id",author_id)
        values.put("exhibition_id",exhibition_id)
        values.put("name",pic_name)
        values.put("detail",pic_detail)
        values.put("image", drawableToByteArray(pic_image!!))
        val wd = writableDatabase
        wd.insert("picture",null,values)
        wd.close()

        Log.d("이미지 저장 테스트", "저장 완료")
    }

    //type에 따른 굿즈 조회 함수.
    @SuppressLint("Range")
    fun selectPicture(picture_id:Int): Picture_Data? {

        val list = arrayListOf<Goods_Data>()
        // db 가져오기
        val select = "select * from picture where p_id="+picture_id

        val rd = readableDatabase

        var picture : Picture_Data? = null

        val cursor = rd.rawQuery(select,null)
        DatabaseUtils.dumpCursor(cursor) //데이터 베이스 확인.

        while(cursor.moveToNext()){

            val p_id:Int = cursor.getInt(cursor.getColumnIndex("p_id"))
            val picture_name:String = cursor.getString(cursor.getColumnIndex("name"))
            val picture_detail:String = cursor.getString(cursor.getColumnIndex("detail"))
            val picture_image:ByteArray? = cursor.getBlob(cursor.getColumnIndex("image"))?:null
            val author_id:Int = cursor.getInt(cursor.getColumnIndex("author_id"))


            picture = Picture_Data(p_id, picture_image, picture_name, picture_detail, author_id)
        }

        cursor.close()
        rd.close()

        return picture
    }




    @SuppressLint("Range")
    fun selectMemo():MutableList<Memo>{
     val list = mutableListOf<Memo>()

     val select = "select * from memo" //  = "select num,content,datetime from memo"

     val rd = readableDatabase
     val cursor = rd.rawQuery(select,null)  //execSQL처럼 쿼리문을 실행하나 rawQuery는 cursor타입의 반환값을 가짐. cursor는 일종의 리스트.
     while(cursor.moveToNext()){
         val num = cursor.getLong(cursor.getColumnIndex("num"))
         val content = cursor.getString(cursor.getColumnIndex("content"))
         val datetime = cursor.getLong(cursor.getColumnIndex("datetime"))

         val memo = Memo(num,content,datetime)
         list.add(memo)
     }
        cursor.close()
        rd.close()

        return list
    }


    //데이터 수정함수
    fun updateMemo(memo:Memo){
        val wd = writableDatabase

        val values = ContentValues()
        values.put("content",memo.content)
        values.put("datetime",memo.datetime)

        wd.update("memo",values,"num = ${memo.num}",null)
        wd.close()

    }

    //데이터 삭제함수

    fun deleteMemo(memo:Memo){
        val wd = writableDatabase
//        val delete = "delete from memo where num = ${memo.num}"
//        wd.execSQL(delete)


        wd.delete("memo","num = ${memo.num}",null)
        wd.close()


    }

    //drawable 파일을 ByteArray로 변환하는 함수.
    fun drawableToByteArray(drawable: Drawable ) : ByteArray?{

        val bitmapDrawable = drawable as BitmapDrawable
        val stream = ByteArrayOutputStream()
        bitmapDrawable.bitmap?.compress(Bitmap.CompressFormat.PNG,100,stream)
        val byteArray = stream.toByteArray()

        return byteArray

    }


    fun compareDates(startDate:String,endDate:String,currentDate:String){

    }



}



data class Memo(var num:Long?,var content:String,var datetime:Long)
