package com.example.values.Activity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.example.values.DTO.Goods_Data
import com.example.values.DTO.User_Data
import java.io.ByteArrayOutputStream


class SqliteHelper(context: MainActivity, name:String, version:Int) : SQLiteOpenHelper(context,name,null,version){
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table user (u_id integer primary key, name text, image blob)")
        db?.execSQL("create table space (s_id integer primary key, name text, address text, image text)")
        db?.execSQL("create table goods (g_id integer primary key, author_id integer, name text, detail text, price text, image blob,type integer, constraint author_id_fk foreign key(author_id) references user(u_id))")
        db?.execSQL("create table exhibition (e_id integer primary key, space_id integer, name text, start_date datetime, end_date datetime, s_id integer, constraint space_id_fk foreign key(space_id) references space(s_id))")
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
        db?.execSQL("DROP TABLE IF EXISTS space")
        db?.execSQL("DROP TABLE IF EXISTS exhibition")
        db?.execSQL("DROP TABLE IF EXISTS picture")
        db?.execSQL("DROP TABLE IF EXISTS reservation")


        db?.execSQL("DROP TABLE IF EXISTS good")
        db?.execSQL("DROP TABLE IF EXISTS goods")
        db?.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db);
        //테이블에 변경사항이 있을 경우 호출됨.
        //SqliteHelper()의 생성자를 호출할 때 기존 데이터베이스와 version을 비교해서 더 높으면
        //호출된다.



    }


    override fun onConfigure(db: SQLiteDatabase?) {

        db?.setForeignKeyConstraintsEnabled(true)  //외래키를 강제
//        db?.disableWriteAheadLogging(); //WAL 해제. Write-ahead logging , 트랜잭션이 일어나기 전 로그를 미리 기록, undo,redo할 수 있도록 함,

        super.onConfigure(db)
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



}



data class Memo(var num:Long?,var content:String,var datetime:Long)
