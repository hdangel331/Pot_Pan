package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by CandiesCLL on 2016/4/21.
 */
public class cll_cp2 extends Activity {
    private Button loginbutton2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_cp2);

        loginbutton2 = (Button) findViewById(R.id.login2);
        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_cp2.this, cll_main.class);
                startActivity(intent);
            }
        });
    }
}
