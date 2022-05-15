package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 *  this class is created by Sant Sharan Singh Rana
 *  on 16 may 2022
 *  developersantsharan@gmail.com
 * */
public class MyHelperJava extends SQLiteOpenHelper {



    private static final String myDb="myDb";
    private static final int version=1;
       public MyHelperJava(Context mContext){
           super(mContext,myDb,null, version);
       }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String createTableCommand="CREATE TABLE EMPLOYEE (_empId INTEGER PRIMARY KEY AUTOINCREMENT, empNAME TEXT, empTEAM TEXT, empSALARY TEXT, empEXPERIENCE TEXT)";
    sqLiteDatabase.execSQL(createTableCommand);
       insert("santosh jaat","Android","10000","3.5",sqLiteDatabase);
       insert("Shivani Jadhav","Android","12000","2.5",sqLiteDatabase);
       insert("Priyanka Bagul","iOS","15000","3.2",sqLiteDatabase);

        //Cursor myCursor=sqLiteDatabase.rawQuery("SELECT empNAME FROM EMPLOYEE",new String[]{});
        /*ContentValues contentValues =new ContentValues();
        contentValues.put("empEXPERIENCE", "2.3");
        sqLiteDatabase.update("EMPLOYEE",contentValues,"_empId = ?",new String[]{"1"});*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void insert(String empName,String empTeam,String salary,String exp,SQLiteDatabase database){
        ContentValues contentValues=new ContentValues();
        contentValues.put("empNAME",empName);
        contentValues.put("empTEAM",empTeam);
        contentValues.put("empSALARY",salary);
        contentValues.put("empEXPERIENCE",exp);
database.insert("EMPLOYEE",null,contentValues);
    }
}
