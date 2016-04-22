package com.example.ziyang.potpan;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class wxx_main extends Activity {

    private Button button2;
    private ImageButton imageButtonlast;
    private Button Button1;
    private Button button3;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;
    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wxx_main);
        mContext = this;
        ImageButton button = (ImageButton) findViewById(R.id.imageButtonLast);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showPopupWindow(view);
            }
        });
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.right_drawer);


        Button1 = (Button) findViewById(R.id.Button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, zzy_main.class);
                startActivity(intent);
            }
        });


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, zzy_main.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, zzy_main.class);
                startActivity(intent);
            }
        });

//
//        imageButtonlast = (ImageButton) findViewById(R.id.imageButtonLast);
//        imageButtonlast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(wxx_main.this, hjy_main.class);
//                startActivity(intent);
//            }
//        });


    }
    private void showPopupWindow(View view) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.hjy_popuplayout, null);
        Button button = (Button) contentView.findViewById(R.id.edt);
        Button thebutton = (Button) contentView.findViewById(R.id.lib);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, hjy_main.class);
                startActivity(intent);
            }
        });
        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, hjy_lib.class);
                startActivity(intent);
            }
        });
        final PopupWindow popupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setTouchable(true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAtLocation(view, Gravity.CENTER,0 ,0);
    }
}
