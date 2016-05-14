package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wxx on 2016/5/4.
 */
public class wxx_feedback extends Activity {

    private Button feedback_submit;
    private int x;
    private TextView Feedbackcontent;
    private String Feedback_content;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_feedback);
    Feedbackcontent = (TextView) findViewById(R.id.Feedback_content);

        feedback_submit = (Button) findViewById(R.id.feedback_submit);
        feedback_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//Use toast to mention that feedback
                String Feedback_content = Feedbackcontent.getText().toString();
                if (Feedback_content == null||Feedback_content.trim().equals("")){

//
                    x=1;


                }else {x=2;}

                if(x==1){
                    Toast.makeText(getApplicationContext(), "Content cannot be empty",
                            Toast.LENGTH_SHORT).show();}

                if(x==2){
                Intent intent = new Intent();
                intent = intent.setClass(wxx_feedback.this,wxx_submitsuccess.class);
                startActivity(intent);
            }
        };
    });
}





}
