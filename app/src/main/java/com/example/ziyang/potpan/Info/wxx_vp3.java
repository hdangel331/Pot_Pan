package com.example.ziyang.potpan.Info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ziyang.potpan.Data.zzy_data;
import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.wxx_main;

public class wxx_vp3 extends Fragment {

    public Button vpbackbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.wxx_vpbg3, container, false);

        //对View中控件的操作方法
        Button vpbackbutton = (Button) view.findViewById(R.id.vpbackbutton);
        vpbackbutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), wxx_main.class);
                i.putExtra("useraccount", zzy_data.getA());
                startActivity(i);
            }
        });
        return view;
    }
}
