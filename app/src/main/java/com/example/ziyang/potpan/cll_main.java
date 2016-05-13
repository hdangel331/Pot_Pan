package com.example.ziyang.potpan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.DATABASE.MaterialDB;
import com.example.ziyang.potpan.DATABASE.RecipeDB;
import com.example.ziyang.potpan.DATABASE.SeasoningDB;
import com.example.ziyang.potpan.DATABASE.UserDB;

import java.util.ArrayList;
import java.util.List;

public class cll_main extends Activity {

    private Button loginbutton;
    private Button Quit;
    private TextView create;
    private TextView retrive;

    private static final String[] MATERIAL_URLS = zzy_constants.MATERIAL;
    private static final String[] MATERIAL_NAMES = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] SEASONING_URLS = zzy_constants.SEASONING;
    private static final String[] SEASONING_NAMES = new String[]{"1", "2", "3", "4", "5"};

    private TextView username;
    private TextView password;
    private int x;
    private ArrayList<String> list1 = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_main);
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
//
//        //再定义read
//        SQLiteDatabase materialread2 = materialdb.getReadableDatabase();
//        SQLiteDatabase seasoningread2 = seasoningdb.getReadableDatabase();
//        //ReceipeDB 获取并创建一个表
//        RecipeDB recipedb = new RecipeDB(this, "recipedb", null, 1);
//        SQLiteDatabase recipewrite = recipedb.getWritableDatabase();
//        recipewrite.execSQL("CREATE TABLE IF NOT EXISTS Eggswithtomatoes(_id INTEGER PRIMARY KEY AUTOINCREMENT, material STRING, seasoning STRING)");
//
//        //从数据库中导出一些material
//        List<String> materiallist = new ArrayList<String>();
//        Cursor c3 = materialread2.query("MaterialDB", new String[]{"materialurl"}, "materialname>=? AND materialname<=?", new String[]{"1", "5"}, null, null, null);
//        while (c3.moveToNext()) {
//            String material = c3.getString(c3.getColumnIndex("materialurl"));
//            materiallist.add(material);
//        }
//        String[] MATERIAL = materiallist.toArray(new String[materiallist.size()]);
//        //从数据库中导出一些seasoning
//        List<String> seasoninglist = new ArrayList<String>();
//        Cursor c4 = seasoningread2.query("SeasoningDB", new String[]{"seasoningurl"}, "seasoningname>=? AND seasoningname<=?", new String[]{"1", "5"}, null, null, null);
//        while (c4.moveToNext()) {
//            String seasoning = c4.getString(c4.getColumnIndex("seasoningurl"));
//            seasoninglist.add(seasoning);
//        }
//        String[] SEASONING = seasoninglist.toArray(new String[seasoninglist.size()]);
//
//        //放入RecipeDB的表中
//        ContentValues cv3 = new ContentValues();
//        for (int i = 0; i < MATERIAL.length; i++) {
//            cv3.put("material", MATERIAL[i]);
//            recipewrite.insert("Eggswithtomatoes", null, cv3);
//            System.out.println(MATERIAL[i]);//ssss
//        }
//        for (int i = 0; i < SEASONING.length; i++) {
//            cv3.put("seasoning", SEASONING[i]);
//            recipewrite.insert("Eggswithtomatoes", null, cv3);
//            System.out.println(SEASONING[i]);//ssss
//        }
//        c3.close();


        //绑定
        username = (TextView) findViewById(R.id.UserName);
        password = (TextView) findViewById(R.id.Password);
        //获得数据库
        UserDB userdb = new UserDB(this);
        final SQLiteDatabase dbread = userdb.getReadableDatabase();
        //查询并添加到list
        Cursor c = dbread.query("UserDB", new String[]{"account", "password"}, null, null, null, null, null);
        while (c.moveToNext()) {
            String a = c.getString(c.getColumnIndex("account"));
            String b = c.getString(c.getColumnIndex("password"));
            list1.add(a);
            list2.add(b);
        }

        //login点击事件
        loginbutton = (Button) findViewById(R.id.login);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入信息
                String UserAccount = username.getText().toString();
                String UserPassword = password.getText().toString();
                //验证是否在数据库中存在
                for (int i = 0; i < list1.size(); i++) {
                    String l1 = list1.get(i).toString();
                    String l2 = list2.get(i).toString();
                    if (UserAccount.equals(l1)) {
                        if (UserPassword.equals(l2)) {
                            x = 2;
                        }
                    }
                }
                //存在则进入
                if (x == 2) {
                    Intent intent = new Intent();
                    intent.setClass(cll_main.this, wxx_main.class);
                    intent.putExtra("useraccount", UserAccount);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Wrong Account or Password",
                            Toast.LENGTH_SHORT).show();}
            }
        });

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(cll_main.this)
                        .setMessage("Are you sure you want to quit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cll_exit.getInstance().exit();
                                    } }
                        )

                        .setNegativeButton("No", null)
                        .show();
            }
        });

        create = (TextView) findViewById(R.id.create);
        retrive = (TextView) findViewById(R.id.retrieve);
        String text1 = "Sign up";
        String text2 = "Forget password";
        SpannableString spannableString1 = new SpannableString(text1);
        spannableString1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cll_main.this, cll_cu.class);
                startActivity(intent);

            }
        }, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString2 = new SpannableString(text2);
        spannableString2.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                Intent intent = new Intent(cll_main.this, cll_retrieve.class);
                startActivity(intent);

            }
        }, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        create.setText(spannableString1);
        create.setMovementMethod(LinkMovementMethod.getInstance());
        retrive.setText(spannableString2);
        retrive.setMovementMethod(LinkMovementMethod.getInstance());


    }
}
