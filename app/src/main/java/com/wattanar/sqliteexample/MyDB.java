package com.wattanar.sqliteexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by wattana_r on 4/4/2559.
 */
public class MyDB  extends SQLiteAssetHelper {
    public static final String DB_NAME = "lexitron.db";
    public static final int DB_VERSION = 1;

    public MyDB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public ArrayList getEmployees(String s) {

        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> myArrList = new ArrayList<String>();

        Cursor c = db.rawQuery("SELECT * FROM eng2thai WHERE esearch LIKE '"+s+"%' LIMIT 1000", null);

        c.moveToFirst();


        try {
            while (c.moveToNext()) {
                myArrList.add(c.getString(c.getColumnIndex("tentry")));
            }
        } finally {
            c.close();
        }

        return myArrList;

    }




}
