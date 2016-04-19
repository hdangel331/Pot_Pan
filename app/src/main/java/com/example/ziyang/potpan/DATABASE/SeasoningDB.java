package com.example.ziyang.potpan.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ziyang on 2016/4/13.
 */
public class SeasoningDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "SeasoningDB";
    public static final String ID = "_id";
    public static final String SEASONINGNAME = "seasoningname";
    public static final String SEASONINGICON = "seasoningicon";
    public static final String SEASONINGID = "seasoningid";


    public SeasoningDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "SeasoningDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        SEASONINGNAME + " VARCHAR(20) NOT NULL, " +
                        SEASONINGID + " INTEGER AUTOINCREMENT, " +
                        SEASONINGICON + " BLOB NOT NULL)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
