package com.example.ziyang.potpan.Login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ziyang.potpan.R;

public class cll_cp2 extends Activity {

    private Button loginbutton2;
    private Button Quit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cll_cp2);
        cll_exit.getInstance().addActivity(this);

        loginbutton2 = (Button) findViewById(R.id.login2);
        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(cll_cp2.this, cll_main.class);
                startActivity(intent);
            }
        });

        Quit = (Button) findViewById(R.id.Quit2);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(cll_cp2.this)
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
