package com.example.ziyang.potpan.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ziyang on 2016/4/13.
 */
public class RecipeDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "RecipeDB";
    public static final String ID = "_id";
    public static final String RECIPEID = "recipeid";
    public static final String RECIPENAME = "recipename";
    public static final String MATERIALID = "materialid";
    public static final String SEASONINGID = "seasoningid";
    public static final String TOOLID = "toolid";


    public RecipeDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "RecipeDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RECIPEID + " INTERGER AUTOINCREMENT, " +
                RECIPENAME + " VARCHAR(20) NOT NULL, " +
                MATERIALID + " INTEGER NOT NULL, " +
                SEASONINGID + " INTEGER NOT NULL, " +
                TOOLID + " INTEGER NOT NULL)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
