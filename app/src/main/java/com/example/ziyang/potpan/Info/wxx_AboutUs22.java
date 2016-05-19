package com.example.ziyang.potpan.Info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.ziyang.potpan.R;

import java.util.ArrayList;
import java.util.List;

public class wxx_AboutUs22 extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_vp);

        //构造适配器
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new wxx_vp1());
        fragments.add(new wxx_vp2());
        fragments.add(new wxx_vp3());
        wxx_AboutUsPagerAdapter adapter = new wxx_AboutUsPagerAdapter(getSupportFragmentManager(), fragments);

        //设定适配器
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
    }


}
