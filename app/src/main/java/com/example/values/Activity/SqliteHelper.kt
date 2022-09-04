package com.example.values.Activity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SqliteHelper(context: Context,name:String,version:Int) : SQLiteOpenHelper(context,name,null,version){
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table user (u_id integer primary key, name text, image text)")
        db?.execSQL("create table space (s_id integer primary key, name text, address text, image text)")
        db?.execSQL("create table good (g_id integer primary key, author_id integer, name text, detail text, address text, image text, constraint author_id_fk foreign key(author_id) references user(u_id))")
        db?.execSQL("create table exhibition (e_id integer primary key, space_id integer, name text, start_date datetime, end_date datetime, s_id integer, constraint space_id_fk foreign key(space_id) references space(s_id))")
        db?.execSQL("create table picture (p_id integer primary key, author_id integer, exhibition_id integer, name text, detail text, image text, constraint author_id_fk foreign key(author_id) references user(u_id), constraint exhibition_id_fk foreign key(exhibition_id) references exhibition(e_id))")
        db?.execSQL("create table reservation (r_id integer primary key, user_id integer, exhibition_id integer, constraint user_id_fk foreign key(user_id) references user(u_id), constraint exhibition_id_fk foreign key(exhibition_id) references exhibition(e_id))")

        db?.execSQL("insert into user (u_id, name, image) values (1, '강승우', 'NULL')")
        db?.execSQL("insert into user (u_id, name, image) values (2, '금윤수', 'NULL')")
        db?.execSQL("insert into user (u_id, name, image) values (3, '김대희', 'NULL')")

        db?.execSQL("insert into space (s_id, name, image) values (2, '금윤수', 'NULL')")



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //테이블에 변경사항이 있을 경우 호출됨.
        //SqliteHelper()의 생성자를 호출할 때 기존 데이터베이스와 version을 비교해서 더 높으면
        //호출된다.



    }

    //데이터 입력함수
    fun insertMemo(memo:Memo){

        // db 가져오기
        val wd = writableDatabase

        //Memo를 입력타입(ContentValues())으로 변환
        val values = ContentValues()
        values.put("content",memo.content)
        values.put("datetime",memo.datetime)

        //db에 넣기"memo", null,값
        wd.insert("memo",null,values)
        //db닫기
        wd.close()

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
}


data class Memo(var num:Long?,var content:String,var datetime:Long)
