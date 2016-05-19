package com.example.ziyang.potpan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.ziyang.potpan.Data.zzy_data;
import com.example.ziyang.potpan.Login.cll_exit;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by CandiesCLL on 2016/5/19.
 */
public class cll_f2 extends Activity {

    private Button back;
    private Button Quit;
    private GifImageView makesteak;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_f2);
        cll_exit.getInstance().addActivity(this);
        makesteak = (GifImageView) findViewById(R.id.makesteak);

        makesteak.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                makesteak.setVisibility(View.INVISIBLE);
            }
        }, 3000);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_f2.this, wxx_main.class);
                intent.putExtra("useraccount", zzy_data.getA());
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
