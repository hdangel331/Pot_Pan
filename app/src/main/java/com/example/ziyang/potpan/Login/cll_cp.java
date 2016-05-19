package com.example.ziyang.potpan.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ziyang.potpan.R;

public class cll_cp extends Activity {
    private Button backbutton1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_cp);
        cll_exit.getInstance().addActivity(this);
        backbutton1 = (Button) findViewById(R.id.back1);
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_cp.this, cll_main.class);
                startActivity(intent);
            }
        });
    }
}

