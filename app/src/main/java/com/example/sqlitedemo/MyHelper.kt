package com.example.sqlitedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

/**
 *  this class is created by Sant Sharan Singh Rana
 *  on 16 may 2022
 *  developersantsharan@gmail.com
 * */
@RequiresApi(Build.VERSION_CODES.P)
class MyHelper(
    context: Context?,
    name: String?,
    version: Int,
    openParams: SQLiteDatabase.OpenParams
) : SQLiteOpenHelper(context, name, version, openParams) {



    val myDb = "myDb"
    val version = 1
    fun MyHelperJava(mContext: Context?) {
     }

   override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val createTableCommand =
            "CREATE TABLE EMPLOYEE (_empId_INTEGER PRIMARY KEY AUTOINCREMENT, empNAME TEXT, empTEAM TEXT, empSALARY INTEGER, empEXPERIENCE TEXT)"
        sqLiteDatabase.execSQL(createTableCommand)
    }

  override  fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, i: Int, i1: Int) {}
}