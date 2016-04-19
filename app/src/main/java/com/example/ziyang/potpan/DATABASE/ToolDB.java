package com.example.ziyang.potpan.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ziyang on 2016/4/13.
 */
public class ToolDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "ToolDB";
    public static final String ID = "_id";
    public static final String TOOLNAME = "toolname";
    public static final String TOOLICON = "toolicon";
    public static final String TOOLID = "toolid";


    public ToolDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "ToolDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TOOLNAME + " VARCHAR(20) NOT NULL, " +
                        TOOLID + " INTEGER AUTOINCREMENT, " +
                        TOOLICON + " BLOB NOT NULL)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
