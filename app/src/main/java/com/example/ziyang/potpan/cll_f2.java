package com.example.ziyang.potpan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ziyang.potpan.Login.cll_exit;

/**
 * Created by CandiesCLL on 2016/5/19.
 */
public class cll_f2 extends Activity {

    private Button back;
    private Button Quit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_f2);
        cll_exit.getInstance().addActivity(this);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_f2.this, wxx_main.class);
                startActivity(intent);
            }
        });

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(cll_f2.this)
                        .setMessage("Are you sure you want to quit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cll_exit.getInstance().exit();
                                    }
                                }
                        )
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }
}
