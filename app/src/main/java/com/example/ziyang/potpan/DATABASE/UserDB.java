package com.example.ziyang.potpan.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ziyang on 2016/4/13.
 */
public class UserDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "UserDB";
    public static final String ID = "_id";
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    public static final String USERNAME = "username";
    public static final String GENDER = "gender";
    public static final String EMAIL = "email";
    public static final String HEAD = "head";

    public UserDB(Context context) {
        super(context, "UserDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ACCOUNT + " VARCHAR(20) NOT NULL, " +
                        PASSWORD + " VARCHAR(60) NOT NULL, " +
                        USERNAME + " VARCHAR(20) DEFAULT \"\", " +
                        GENDER + " STRING DEFAULT \"\", " +
                        EMAIL + " VARCHAR(60) DEFAULT \"\", " +
                        HEAD + " BLOB DEFAULT \"\")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
