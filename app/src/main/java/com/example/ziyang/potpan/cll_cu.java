package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.DATABASE.UserDB;
import com.example.ziyang.potpan.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CandiesCLL on 2016/4/18.
 */
public class cll_cu extends Activity {
    private Button completebutton;
    private Button backbutton2;
    private int x;
    private TextView createuser;
    private TextView createpassword1;
    private TextView retypeP;
    private TextView createemail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_cu);
        cll_exit.getInstance().addActivity(this);
        //获得数据库
        UserDB userdb = new UserDB(this);
        final SQLiteDatabase dbwrite = userdb.getWritableDatabase();
        //绑定
        createuser = (TextView) findViewById(R.id.CreateUser);
        createpassword1 = (TextView) findViewById(R.id.CreatePassword);
        retypeP = (TextView) findViewById(R.id.RetypeP);
        createemail = (TextView) findViewById(R.id.Email);

        //complete点击事件
        completebutton = (Button) findViewById(R.id.complete);
        completebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入信息
                String Account = createuser.getText().toString();
                String Password = createpassword1.getText().toString();
                String RetypeP = retypeP.getText().toString();
                String Email = createemail.getText().toString();

                if (Password.equals( RetypeP)) {
                    x = 1;
                }else {

               x=2;}
                if (x==2){
                   Toast.makeText(getApplicationContext(), "Wrong Retype Password",
                            Toast.LENGTH_SHORT).show();
              }
                   if (x==1){
                   //以账户为名创建用户自己的表
                   dbwrite.execSQL("CREATE TABLE " + Account + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, recipename STRING)");
                   ContentValues usercv = new ContentValues();
                   //放入初始菜谱
                   String[] recipelist = new String[]{"Eggs with tomatoes", "Steak", "Squirrel-shaped mandarin fish",};
                   for (int i = 0; i < 3; i++) {
                       usercv.put("recipename", recipelist[i]);
                       dbwrite.insert(Account, null, usercv);
                   }
                   //把用户信息放入主用户表
                   ContentValues cv = new ContentValues();
                   cv.put("account", Account);
                   cv.put("password", Password);
                   cv.put("email", Email);
                   dbwrite.insert("UserDB", null, cv);
                   dbwrite.close();

                   //跳转
                       Intent intent = new Intent();
                       intent.setClass(cll_cu.this, cll_cp.class);
                       startActivity(intent);

               }
            }

        });

        //back点击事件
        backbutton2 = (Button) findViewById(R.id.back2);
        backbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_cu.this, cll_main.class);
                startActivity(intent);
            }
        });
    }
}