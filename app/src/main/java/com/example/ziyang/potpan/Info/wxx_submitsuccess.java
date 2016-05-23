package com.example.ziyang.potpan.Info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ziyang.potpan.Login.cll_exit;
import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.Main.wxx_main;
import com.example.ziyang.potpan.Data.zzy_data;

public class wxx_submitsuccess extends Activity {
    private Button submitbackbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_submitsuccess);
        cll_exit.getInstance().addActivity(this);

        submitbackbutton = (Button) findViewById(R.id.submit_back);
        submitbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(wxx_submitsuccess.this, wxx_main.class);
                intent.putExtra("useraccount", zzy_data.getA());
                startActivity(intent);
                wxx_submitsuccess.this.finish();
            }
        });
    }
}