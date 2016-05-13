package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.DATABASE.UserDB;
import com.example.ziyang.potpan.util.SocketClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.ziyang.potpan.zzy_constants.*;
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
            public void onClick(View v) {
                //获得输入信息
                String Account = createuser.getText().toString();
                String Password = createpassword1.getText().toString();
                String RetypeP = retypeP.getText().toString();
                String Email = createemail.getText().toString().trim();

                final String value[] = new String[3];
                value[0] = Account;
                value[1] = Password;
                value[2] = Email;

                Matcher matcherObj = Pattern.compile(CEmail).matcher(Email);

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

                if (x == 2) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            StringBuffer submitContent = new StringBuffer();//定义服务器
                            for (int i = 0; i < value.length; i++) {
                                submitContent.append(ADD_USERINFO + value[i]);//将员工信息添加到字符串中
                            }
                            SocketClient.ConnectSevert(submitContent.toString());//将员工信息传给服务器
                            String readinfo = SocketClient.readinfo;
                            System.out.println(readinfo);
                            if (readinfo.equals("ok"))//如果返回“ok”
                            {
                                //跳转
                                Intent intent = new Intent();
                                intent.setClass(cll_cu.this, cll_cp.class);
                                startActivity(intent);
                            }else {
                                System.out.print("false");
                            }
                        }
                    }).start();
                }
                if (x == 1) {
                    Toast.makeText(getApplicationContext(), "Please enter correct information",
                            Toast.LENGTH_SHORT).show();
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