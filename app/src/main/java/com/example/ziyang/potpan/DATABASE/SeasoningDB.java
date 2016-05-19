package com.example.ziyang.potpan.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SeasoningDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "SeasoningDB";
    public static final String ID = "_id";
    public static final String SEASONINGNAME = "seasoningname";
    public static final String SEASONINGURL = "seasoningurl";

    public SeasoningDB(Context context) {
        super(context, "SeasoningDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        SEASONINGNAME + " VARCHAR(20) NOT NULL, " +
                        SEASONINGURL + " STRING NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
