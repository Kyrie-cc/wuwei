package com.example.administrator.sport.activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.administrator.sport.bean.ItemBean;
import com.example.administrator.sport.bean.People;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */

public class DB_C {
    private  List<People> list;
    private SQLiteDatabase db;
    public DB_C(Context context) {
        db=new DB_M(context).getWritableDatabase();
    }
    public void add(String imgurl1, String imgur2, String imgur3,
                    String title, String author,String date,String url){
        String sql ="insert into "+DB_M.table_name+" values(null,'"+url+"','"+imgurl1+
                "','"+imgur2+"','"+imgur3+"','"+author+"','"+title+"','"+date+"')";
        db.execSQL(sql);
    }
    public void delete(List<People> list){
//        String sql="delete from "+DB_M.table_name+" where url='"+url+"','"+imgurl+
//                "','"+content+"','"+name+"'";

        for (People u:list) {
            Log.e("msg",u.isCheck()+"");
            if(u.isCheck()){
//                String sql="delete from " + DB_M.table_name + " where url = '"+u.getUrl()+"'";
//                Log.e("msg1",sql);
//                db.execSQL(sql);
                String sql="delete from " + DB_M.table_name + " where title = '"+u.getTitle()+"'";

                Log.e("mm","6666"+sql);
                db.execSQL(sql);
            }

        }
        this.list=list;

    }
    public  List<People> getList(){

        return list;
    }
    public List<People> show(){
        ArrayList<People> list = new ArrayList<>();
        ArrayList<People> newList = new ArrayList<>();
        String sql=" select * from "+ DB_M.table_name ;
        Cursor cursor = db.rawQuery(sql,null);
        if(!cursor.isAfterLast()){
            while(cursor.moveToNext()){
                list.add(new People(cursor.getString(cursor.getColumnIndex("imgurl1")),
                        cursor.getString(cursor.getColumnIndex("imgur2")),
                        cursor.getString(cursor.getColumnIndex("imgur3")),
                        cursor.getString(cursor.getColumnIndex("title")),
                        cursor.getString(cursor.getColumnIndex("author")),
                        cursor.getString(cursor.getColumnIndex("date")),
                        cursor.getString(cursor.getColumnIndex("url"))));
            }
            cursor.close();
        }
        if(list!=null){
            for(int i=0;i<list.size();i++){
                newList.add(list.get(list.size()-i-1));
            }
        }
        return newList;
    }
}
