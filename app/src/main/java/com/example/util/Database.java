package com.example.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app.GongZhong;

public class Database extends SQLiteOpenHelper {
    private static final String D_NAME="GongZhong";
    private static final String TB_NAME="tb_gongzhong";
    private static final String CRE_TB="create table "+TB_NAME+"(id integer primary key autoincrement,name text,info text)";
    private SQLiteDatabase dd;

    public  Database(Context context){
        super(context,D_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        dd=sqLiteDatabase;
        dd.execSQL(CRE_TB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void tian(ContentValues values){
        dd=getWritableDatabase();
        dd.insert(TB_NAME,null,values);
        dd.close();
    }
    public void del(int id){
        if(dd==null){
            dd=getWritableDatabase();
        }
        dd.delete(TB_NAME,"id=?",new String[]{String.valueOf(id)});
        dd.close();
    }
    public Cursor cha(){
        dd=getWritableDatabase();
        Cursor cur=dd.query(TB_NAME,null,null,null,null,null,null,null);
        return cur;
    }
    public void xiugai(GongZhong gongzhong){
        dd=getWritableDatabase();
        ContentValues con=new ContentValues();
        con.put("name",gongzhong.getName());
        con.put("info",gongzhong.getJieshao());
        dd.update(TB_NAME,con,"id=?",new String[]{String.valueOf(gongzhong.getId())});
        dd.close();

    }

}
