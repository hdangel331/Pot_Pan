package com.example.ziyang.potpan;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class ZhangziyangFragment extends Fragment {

    private int[] materialID = {R.drawable.meet,R.drawable.mashroom,R.drawable.egg};
    private int[] seasoningID = {R.drawable.oil,R.drawable.sauce};
    private ListView listView1,listView2;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageButton imageButton1;


    public ZhangziyangFragment() {
    }
    private void add(int i) {
    }
    private void openfire() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //显示界面
        final View zhangziyang = inflater.inflate(R.layout.zhangziyang, container, false);

        //适配器1号
        List<Map<String,Object>> List1 = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i < materialID.length ; i++){
            Map<String, Object> Content1 = new HashMap<String,Object>();
            Content1.put("material",materialID[i]);
            List1.add(Content1);
        }
        SimpleAdapter SP1 = new SimpleAdapter(container.getContext(), List1, R.layout.zzyimage1, new String[]{"material"}, new int[]{R.id.image1});
        listView1 = (ListView) zhangziyang.findViewById(R.id.listview1);
        listView1.setAdapter(SP1);

        //适配器2号
        List<Map<String,Object>> List2 = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i < seasoningID.length ; i++){
            Map<String, Object> Content2 = new HashMap<String,Object>();
            Content2.put("seasoning",seasoningID[i]);
            List2.add(Content2);
        }
        SimpleAdapter SP2 = new SimpleAdapter(container.getContext(), List2, R.layout.zzyimage2, new String[]{"seasoning"}, new int[]{R.id.image2});
        listView2 = (ListView) zhangziyang.findViewById(R.id.listview2);
        listView2.setAdapter(SP2);

        //点击事件
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView2 = (ImageView) zhangziyang.findViewById(R.id.image2);
                switch (position){
                    case 0:
                        add(0);
                        break;
                    case 1:
                        add(1);
                        break;
                    case 2:
                        add(2);
                        break;

                }
            }
        });

        //button
        imageButton1 = (ImageButton) zhangziyang.findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfire();
            }
        });






        return zhangziyang;
    }


}
