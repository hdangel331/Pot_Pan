package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by wxx on 2016/5/5.
 */
public class wxx_submitsuccess extends Activity {
    private Button submitbackbutton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_submitsuccess);

        submitbackbutton = (Button) findViewById(R.id.submit_back);
        submitbackbutton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent = new Intent();
                                                    intent.setClass(wxx_submitsuccess.this, wxx_main.class);
                                                    startActivity(intent);

                                                }
                                            }

        );
    }
}