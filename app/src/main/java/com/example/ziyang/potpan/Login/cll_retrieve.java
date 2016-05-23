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

import static com.example.ziyang.potpan.Data.zzy_constants.*;

public class cll_retrieve extends Activity {

    private Button confirmbutton;
    private Button backbutton3;
    private TextView username;
    private TextView email;
    private Handler myHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_retrieve);
        cll_exit.getInstance().addActivity(this);

        //绑定
        username = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);

        confirmbutton = (Button) findViewById(R.id.confirm);
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String UserAccount = username.getText().toString();
                final String UserEmail = email.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        StringBuffer submitContent = new StringBuffer();
                        submitContent.append(GET_EMAILBYACCOUNT + UserAccount);
                        SocketClient.ConnectSevert(submitContent.toString());
                        String readinfo = SocketClient.readinfo;
                        if (readinfo.equals(UserEmail)) {
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
                                intent.setClass(cll_retrieve.this, cll_reset.class);
                                startActivity(intent);
                                cll_retrieve.this.finish();
                                break;
                            case 2:
                                Toast.makeText(getApplicationContext(), "Wrong Account or Email",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                        super.handleMessage(msg);
                    }
                };
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
