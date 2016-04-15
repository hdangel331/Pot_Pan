package com.example.ziyang.potpan;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class CailinglongFragment extends Fragment {

    public CailinglongFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //显示界面
        View cailinglong = inflater.inflate(R.layout.cailinglong, container,false);

        //点击事件
        cailinglong.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,new WangxiaoxuanFragment())
                        .commit();
            }
        });



        return cailinglong;
    }
}
