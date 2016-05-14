package com.example.ziyang.potpan;

import android.app.Activity;
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

import java.util.ArrayList;

/**
 * Created by CandiesCLL on 2016/4/20.
 */
public class cll_reset extends Activity {
    private Button completebutton;
    private TextView account;
    private TextView Npassword;
    private TextView Rpassword;
    int x;
    private ArrayList<String> list1 = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_reset);
        cll_exit.getInstance().addActivity(this);

        //获得数据库
        UserDB userdb = new UserDB(this);
        final SQLiteDatabase dbwrite = userdb.getWritableDatabase();
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
                if (UserAccount == null || UserAccount.trim().equals("")) {
                    account.setError("Please enter your account");
                    x = 1;
                    return;
                } else {//验证是否在数据库中存在
                    for (int i = 0; i < list1.size(); i++) {
                        String l1 = list1.get(i).toString();
                        if (UserAccount.equals(l1)) {

                        //密码更改

                            x=2;
                            Intent intent = new Intent();
                            intent.setClass(cll_reset.this, cll_cp2.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Error Account",
                                    Toast.LENGTH_SHORT).show();
                            x=1;
                        }

            }}}
        });
    }
        }