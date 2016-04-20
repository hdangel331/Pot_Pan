package com.example.ziyang.potpan;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class WangxiaoxuanFragment extends Fragment {
    public WangxiaoxuanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //显示界面
        View wangxiaoxuan = inflater.inflate(R.layout.wangxiaoxuan, container,false);

        //点击事件1
        wangxiaoxuan.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,new ZhangziyangFragment())
                        .commit();

            }
        });


        //点击事件2
        wangxiaoxuan.findViewById(R.id.imageButtonLast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,new HongjingyeFragment())
                        .commit();

            }
        });




        return wangxiaoxuan;
    }


}
