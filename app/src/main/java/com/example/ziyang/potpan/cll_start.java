package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by CandiesCLL on 2016/4/24.
 */
public class cll_start extends Activity{
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_start);
        startMainAvtivity();
    }
    private void startMainAvtivity() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                intent = new Intent(cll_start.this, cll_main.class);
                startActivity(intent);
                cll_start.this.finish();//结束本Activity
            }
        }, 3000);//设置执行时间
    }
}

