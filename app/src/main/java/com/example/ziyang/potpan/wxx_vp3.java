package com.example.ziyang.potpan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by wxx on 2016/5/12.
 */
public class wxx_vp3 extends Fragment {

    public Button vpbackbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.wxx_vpbg3, container, false);

        //对View中控件的操作方法
        Button vpbackbutton = (Button)view.findViewById(R.id.vpbackbutton);
        vpbackbutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),wxx_main.class);

                startActivity(i);

            }
        });
        return view;
    }



}
