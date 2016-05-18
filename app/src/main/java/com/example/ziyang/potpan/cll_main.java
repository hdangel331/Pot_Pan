package com.example.ziyang.potpan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.DATABASE.MaterialDB;
import com.example.ziyang.potpan.DATABASE.SeasoningDB;
import com.example.ziyang.potpan.util.SocketClient;

import java.util.ArrayList;
import java.util.List;

import static com.example.ziyang.potpan.zzy_constants.GET_PASSWORDBYACCOUNT;
import static com.example.ziyang.potpan.zzy_constants.MATERIAL;
import static com.example.ziyang.potpan.zzy_constants.MATERIALNAME;
import static com.example.ziyang.potpan.zzy_constants.SEASONING;
import static com.example.ziyang.potpan.zzy_constants.SEASONINGNAME;

public class cll_main extends Activity {

    private Button loginbutton;
    private Button Quit;
    private TextView create;
    private TextView retrive;

    private static final String[] MATERIAL_URLS = MATERIAL;
    private static final String[] MATERIAL_NAMES = MATERIALNAME;
    private static final String[] SEASONING_URLS = SEASONING;
    private static final String[] SEASONING_NAMES = SEASONINGNAME;

    private TextView username;
    private TextView password;

    private Handler myHandler;

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

        //绑定
        username = (TextView) findViewById(R.id.UserName);
        password = (TextView) findViewById(R.id.Password);

        //login点击事件
        loginbutton = (Button) findViewById(R.id.login);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入信息
                final String UserAccount = username.getText().toString();
                final String UserPassword = password.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        StringBuffer submitContent = new StringBuffer();//定义服务器
                        submitContent.append(GET_PASSWORDBYACCOUNT + UserAccount);//将员工信息添加到字符串中
                        SocketClient.ConnectSevert(submitContent.toString());//将员工信息传给服务器
                        String readinfo = SocketClient.readinfo;
                        if (readinfo.equals(UserPassword)) {
                            Message message = new Message();
                            message.what = 1;
                            myHandler.sendMessage(message);
                        } else {
                            Message message = new Message();
                            message.what = 2;
                            myHandler.sendMessage(message);
                        }
                    }
                }).start();

                myHandler = new Handler() {
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 1:
                                Intent intent = new Intent();
                                intent.setClass(cll_main.this, wxx_main.class);
                                intent.putExtra("useraccount", UserAccount);
                                startActivity(intent);
                                break;
                            case 2:
                                Toast.makeText(getApplicationContext(), "Wrong Account or Password",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                        super.handleMessage(msg);
                    }
                };
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
                                    }
                                }
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
