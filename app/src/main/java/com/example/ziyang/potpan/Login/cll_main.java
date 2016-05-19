package com.example.ziyang.potpan.Login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.util.SocketClient;
import com.example.ziyang.potpan.wxx_main;

import static com.example.ziyang.potpan.Data.zzy_constants.*;

public class cll_main extends Activity {

    private Button loginbutton, Quit;
    private TextView create, retrive, username, password;
    private Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_main);
        cll_exit.getInstance().addActivity(this);

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
