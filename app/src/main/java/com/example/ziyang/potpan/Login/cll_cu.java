package com.example.ziyang.potpan.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.util.SocketClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.ziyang.potpan.Data.zzy_constants.ADD_USERINFO;

public class cll_cu extends Activity {
    private Button completebutton;
    private Button backbutton2;
    private int x;
    private TextView createuser;
    private TextView createpassword1;
    private TextView retypeP;
    private TextView createemail;
    private Handler myHandler;
    private String CEmail =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_cu);
        cll_exit.getInstance().addActivity(this);

        //绑定
        createuser = (TextView) findViewById(R.id.CreateUser);
        createpassword1 = (TextView) findViewById(R.id.CreatePassword);
        retypeP = (TextView) findViewById(R.id.RetypeP);
        createemail = (TextView) findViewById(R.id.Email);

        //complete点击事件
        completebutton = (Button) findViewById(R.id.complete);
        completebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //获得输入信息
                String Account = createuser.getText().toString();
                String Password = createpassword1.getText().toString();
                String RetypeP = retypeP.getText().toString();
                String Email = createemail.getText().toString().trim();
                Matcher matcherObj = Pattern.compile(CEmail).matcher(Email);

                final String value[] = new String[3];
                value[0] = Account;
                value[1] = Password;
                value[2] = Email;

                if (Account == null || Account.trim().equals("")) {
                    createuser.setError("Please enter your account");
                    x = 1;
                    return;
                } else if (Password == null || Password.trim().equals("")) {
                    createpassword1.setError("Please enter your password");
                    x = 1;
                    return;
                } else if (RetypeP == null || RetypeP.trim().equals("")) {
                    retypeP.setError("Please enter your password");
                    x = 1;
                    return;
                }
                if (Password.equals(RetypeP)) {
                    x = 2;
                } else {
                    retypeP.setError("Incorrect password");
                    x = 1;
                    return;
                }
                if (matcherObj.matches()) {
                    x = 2;
                } else {
                    createemail.setError("Your Email is invalid");
                    x = 1;
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        StringBuffer submitContent = new StringBuffer();//定义服务器
                        for (int i = 0; i < value.length; i++) {
                            submitContent.append(ADD_USERINFO + value[i]);//将员工信息添加到字符串中
                        }
                        SocketClient.ConnectSevert(submitContent.toString());//将员工信息传给服务器
                        String readinfo = SocketClient.readinfo;
                        if (readinfo.equals("ok")) {
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
                                intent.setClass(cll_cu.this, cll_cp.class);
                                startActivity(intent);
                                break;
                            case 2:
                                Toast.makeText(getApplicationContext(), "Please enter correct information",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                        super.handleMessage(msg);
                    }
                };
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