package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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

import java.util.ArrayList;

/**
 * Created by CandiesCLL on 2016/4/20.
 */
public class cll_retrieve extends Activity {
    private Button confirmbutton;
    private Button backbutton3;
    private TextView username;
    private TextView email;
    private ArrayList<String> list1 = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();
    int x;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_retrieve);
        cll_exit.getInstance().addActivity(this);

        //绑定
        username = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        //获得数据库
        UserDB userdb = new UserDB(this);
        final SQLiteDatabase dbread = userdb.getReadableDatabase();
        //查询并添加到list
        Cursor c = dbread.query("UserDB", new String[]{"account", "email"}, null, null, null, null, null);
        while (c.moveToNext()) {
            String a = c.getString(c.getColumnIndex("account"));
            String b = c.getString(c.getColumnIndex("email"));
            list1.add(a);
            list2.add(b);
        }

        confirmbutton = (Button) findViewById(R.id.confirm);
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入信息
                String UserAccount = username.getText().toString();
                String UserEmail = email.getText().toString();
                //验证是否在数据库中存在
                for (int i = 0; i < list1.size(); i++) {
                    String l1 = list1.get(i).toString();
                    String l2 = list2.get(i).toString();
                    if (UserAccount.equals(l1)) {
                        if (UserEmail.equals(l2)) {
                            x = 2;
                        }
                    }
                }
                if (x == 2) {
                Intent intent = new Intent();
                intent.setClass(cll_retrieve.this, cll_reset.class);
                startActivity(intent);
            }else {
                    Toast.makeText(getApplicationContext(), "Wrong Account or Email",
                            Toast.LENGTH_SHORT).show();}
            }
        });

        backbutton3 = (Button) findViewById(R.id.back3);
        backbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_retrieve.this, cll_main.class);
                startActivity(intent);
            }
        });
    }
}
