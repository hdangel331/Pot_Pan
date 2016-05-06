package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by wxx on 2016/5/4.
 */
public class wxx_feedback extends Activity {

    private Button feedback_submit;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_feedback);

        feedback_submit = (Button) findViewById(R.id.feedback_submit);
        feedback_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(wxx_feedback.this,wxx_submitsuccess.class);
                startActivity(intent);
            }
        });
    }






}
