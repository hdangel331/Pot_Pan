package com.example.ziyang.potpan.Login;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

import com.example.ziyang.potpan.DATABASE.MaterialDB;
import com.example.ziyang.potpan.DATABASE.SeasoningDB;
import com.example.ziyang.potpan.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.ziyang.potpan.Data.zzy_constants.*;

public class cll_start extends Activity {

    private Intent intent;
    private static final String[] MATERIAL_URLS = MATERIAL;
    private static final String[] MATERIAL_NAMES = MATERIALNAME;
    private static final String[] SEASONING_URLS = SEASONING;
    private static final String[] SEASONING_NAMES = SEASONINGNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_start);
        startMainAvtivity();
        cll_exit.getInstance().addActivity(this);

        //MaterialDB 获取
        MaterialDB materialdb = new MaterialDB(this, "materialdb", null, 1);
        SQLiteDatabase materialwrite = materialdb.getWritableDatabase();
        SQLiteDatabase materialread1 = materialdb.getReadableDatabase();
        //SeasoningDB 获取
        SeasoningDB seasoningdb = new SeasoningDB(this, "seasoningdb", null, 1);
        SQLiteDatabase seasoningwrite = seasoningdb.getWritableDatabase();
        SQLiteDatabase seasoningread1 = seasoningdb.getReadableDatabase();

        //MaterialDB 先判断再写入
        final List<String> list3 = new ArrayList<String>();
        Cursor c1 = materialread1.query("MaterialDB", new String[]{"materialurl"}, null, null, null, null, null);
        while (c1.moveToNext()) {
            String a = c1.getString(c1.getColumnIndex("materialurl"));
            list3.add(a);
        }
        if (list3.size() < 1) {
            ContentValues cv1 = new ContentValues();
            for (int i = 0; i < MATERIAL_URLS.length; i++) {
                cv1.put("materialname", MATERIAL_NAMES[i]);
                cv1.put("materialurl", MATERIAL_URLS[i]);
                materialwrite.insert("MaterialDB", null, cv1);
            }
        }
        c1.close();
        materialwrite.close();

        //SeasoningDB 先判断再写入
        final List<String> list4 = new ArrayList<String>();
        Cursor c2 = seasoningread1.query("SeasoningDB", new String[]{"seasoningurl"}, null, null, null, null, null);
        while (c2.moveToNext()) {
            String b = c2.getString(c2.getColumnIndex("seasoningurl"));
            list4.add(b);
        }
        if (list4.size() < 1) {
            ContentValues cv2 = new ContentValues();
            for (int i = 0; i < SEASONING_URLS.length; i++) {
                cv2.put("seasoningname", SEASONING_NAMES[i]);
                cv2.put("seasoningurl", SEASONING_URLS[i]);
                seasoningwrite.insert("SeasoningDB", null, cv2);
            }
        }
        c2.close();
        seasoningwrite.close();

    }

    private void startMainAvtivity() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                intent = new Intent(cll_start.this, cll_main.class);
                startActivity(intent);
                cll_start.this.finish();//结束本Activity
            }
        }, 3000);//设置执行时间
    }
}

