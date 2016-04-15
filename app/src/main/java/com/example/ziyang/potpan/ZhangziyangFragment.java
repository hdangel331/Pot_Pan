package com.example.ziyang.potpan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class ZhangziyangFragment extends Fragment {

    public ZhangziyangFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //显示界面
        View zhangziyang = inflater.inflate(R.layout.zhangziyang, container, false);

        return zhangziyang;
    }
}
