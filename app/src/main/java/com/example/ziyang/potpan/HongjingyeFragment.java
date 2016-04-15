package com.example.ziyang.potpan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class HongjingyeFragment extends Fragment {

    public HongjingyeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //显示界面
        View hongjingye = inflater.inflate(R.layout.hongjingye, container, false);

        return hongjingye;
    }
}
