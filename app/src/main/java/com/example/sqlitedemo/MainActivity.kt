package com.example.sqlitedemo

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
/**
 *  this class is created by Sant Sharan Singh Rana
 *  on 16 may 2022
 *  developersantsharan@gmail.com
 * */
class MainActivity : AppCompatActivity() {
    lateinit var sqLiteDatabase:SQLiteDatabase
    private val textView:TextView
    get() = findViewById(R.id.tv_empDetails)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myHelperJava=MyHelperJava(this)
        sqLiteDatabase=myHelperJava.readableDatabase
// we can  insert data from helper class and from our activity
        /*val contentValues = ContentValues()
        contentValues.put("empNAME", "Aman")
        contentValues.put("empTEAM", "iOS")
        contentValues.put("empSALARY", "10000")
        contentValues.put("empEXPERIENCE", "0.9")
        sqLiteDatabase.insert("EMPLOYEE",null,contentValues)*/

        //Cursor myCursor=sqLiteDatabase.rawQuery("SELECT empNAME FROM EMPLOYEE",new String[]{});
        val contentValues = ContentValues()
        contentValues.put("empEXPERIENCE", "2.8")
        sqLiteDatabase.update("EMPLOYEE", contentValues, "_empId = ?", arrayOf("2"))
        sqLiteDatabase.update("EMPLOYEE", contentValues, "empNAME = ? AND empEXPERIENCE = ?", arrayOf("hemant","5.9"))

/**
 * for deleting row from sqlite database
 * */
        sqLiteDatabase.delete("EMPLOYEE","_empId = ?", arrayOf("3"))




        val myCursor = sqLiteDatabase.rawQuery("SELECT empNAME,empTEAM,empEXPERIENCE FROM EMPLOYEE", arrayOf())

        if (myCursor!=null){
            myCursor.moveToFirst()
        }
         val stringBuilder=StringBuilder()
        do {
            val name=myCursor.getString(0)
            val team=myCursor.getString(1)
            val exp=myCursor.getString(2)
            stringBuilder.append("name = $name        Team = $team      Exp=$exp\n")
        }while (myCursor.moveToNext())

        textView.text=stringBuilder.toString()
    }


}