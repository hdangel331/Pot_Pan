package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.util.SocketClient;

import static com.example.ziyang.potpan.zzy_constants.UPDATE_PASSWORD;

/**
 * Created by CandiesCLL on 2016/4/20.
 */
public class cll_reset extends Activity {
    private Button completebutton;
    private TextView account;
    private TextView Npassword;
    private TextView Rpassword;
    private Handler myHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_reset);
        cll_exit.getInstance().addActivity(this);

        //绑定
        account = (TextView) findViewById(R.id.User);
        Npassword = (TextView) findViewById(R.id.ResetP);
        Rpassword = (TextView) findViewById(R.id.RetypeP);

        completebutton = (Button) findViewById(R.id.complete);
        completebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入信息
                String UserAccount = account.getText().toString();
                String NewPassword = Npassword.getText().toString();
                String RPassword = Rpassword.getText().toString();

                final String value[] = new String[2];
                value[0] = UserAccount;
                value[1] = NewPassword;

                if (UserAccount == null || UserAccount.trim().equals("")) {
                    account.setError("Please enter your account");
                    return;
                } else {//验证是否在数据库中存在
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            StringBuffer submitContent = new StringBuffer();//定义服务器
                            for (int i = 0; i < value.length; i++) {
                                submitContent.append(UPDATE_PASSWORD + value[i]);//将信息添加到字符串中
                            }
                            SocketClient.ConnectSevert(submitContent.toString());//将信息传给服务器
                            String readinfo = SocketClient.readinfo;
                            System.out.println(readinfo);
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
                                    intent.setClass(cll_reset.this, cll_cp2.class);
                                    startActivity(intent);
                                    break;
                                case 2:
                                    Toast.makeText(getApplicationContext(), "Error Account",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            super.handleMessage(msg);
                        }
                    };
                }
            }
        });
    }
}