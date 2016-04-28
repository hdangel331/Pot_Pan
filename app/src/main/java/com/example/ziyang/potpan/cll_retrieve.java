package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by CandiesCLL on 2016/4/20.
 */
public class cll_retrieve extends Activity {
    private Button confirmbutton;
    private Button backbutton3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_retrieve);

        confirmbutton = (Button) findViewById(R.id.confirm);
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_retrieve.this, cll_reset.class);
                startActivity(intent);
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
