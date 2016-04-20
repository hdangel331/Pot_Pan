package com.example.ziyang.potpan.DATABASE;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.ziyang.potpan.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by Ziyang on 2016/4/13.
 */
public class MaterialDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "MaterialDB";
    public static final String ID = "_id";
    public static final String MATERIALNAME = "materialname";
    public static final String MATERIALICON = "materialicon";
    public static final String MATERIALID = "materialid";

//    private Context mContext;


    public MaterialDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "MaterialDB", null, 1);
//        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        MATERIALNAME + " VARCHAR(20) NOT NULL, " +
                        MATERIALID + " INTEGER AUTOINCREMENT, " +
                        MATERIALICON + " BLOB NOT NULL)"
        );

//        initDatabase(db,mContext);

    }
//
//    private void initDatabase(SQLiteDatabase db,Context context){
//        Drawable drawable = context.getResources().getDrawable(R.drawable.egg);
//        ContentValues cv =new ContentValues();
//        cv.put(MATERIALICON, getPicture(drawable));
//        db.insert(TABLE_NAME, null, cv);
//    }
//
//    private  byte[] getPicture(Drawable drawable){
//        if (drawable == null){
//            return null;
//        }
//        BitmapDrawable bd = (BitmapDrawable) drawable;
//        Bitmap bitmap = bd.getBitmap();
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG,100,os);
//        return os.toByteArray();
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
