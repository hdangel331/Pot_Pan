package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ziyang.potpan.R;

/**
 * Created by CandiesCLL on 2016/4/18.
 */
public class cll_cu extends Activity {
    private Button completebutton;
    private Button backbutton2;
//    private TextView createuser;
//    private TextView createpassword1;
//    private TextView createpassword2;
//    private TextView createemail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_cu);

//        UserDB userdb = new UserDB(this);
//        final SQLiteDatabase dbwrite = userdb.getWritableDatabase();

//        createuser = (TextView) findViewById(R.id.CreateUser);
//        createpassword1 = (TextView) findViewById(R.id.CreatePassword);
//        createpassword2 = (TextView) findViewById(R.id.RetypeP);
//        createemail = (TextView) findViewById(R.id.Email);

        completebutton = (Button) findViewById(R.id.complete);
        completebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String Account = createuser.getText().toString();
//                String Password = createpassword1.getText().toString();
//                String Email = createemail.getText().toString();
//                if (Password != createpassword2.getText().toString()) {
//
//                }
//                ContentValues cv = new ContentValues();
//                cv.put("account", Account);
//                cv.put("password", Password);
//                cv.put("email", Email);
//                dbwrite.insert("UserDB", null, cv);
//                dbwrite.close();
                Intent intent = new Intent();
                intent.setClass(cll_cu.this, cll_cp.class);
                startActivity(intent);
            }
        });
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