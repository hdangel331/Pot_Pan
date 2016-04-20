package com.example.ziyang.potpan;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
public class zzy_main extends Activity {

    private int[] materialID = {R.drawable.zzy_meet,R.drawable.zzy_mashroom,R.drawable.zzy_egg};
    private int[] seasoningID = {R.drawable.zzy_oil,R.drawable.zzy_sauce};
    private ListView listView1,listView2;
    private ImageButton imageButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzy_main);

        //适配器1号
        List<Map<String,Object>> List1 = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i < materialID.length ; i++){
            Map<String, Object> Content1 = new HashMap<String,Object>();
            Content1.put("material",materialID[i]);
            List1.add(Content1);
        }
        SimpleAdapter SP1 = new SimpleAdapter(this, List1, R.layout.zzy_image1, new String[]{"material"}, new int[]{R.id.image1});
        listView1 = (ListView)findViewById(R.id.listview1);
        listView1.setAdapter(SP1);

        //适配器2号
        List<Map<String,Object>> List2 = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i < seasoningID.length ; i++){
            Map<String, Object> Content2 = new HashMap<String,Object>();
            Content2.put("seasoning",seasoningID[i]);
            List2.add(Content2);
        }
        SimpleAdapter SP2 = new SimpleAdapter(this, List2, R.layout.zzy_image2, new String[]{"seasoning"}, new int[]{R.id.image2});
        listView2 = (ListView)findViewById(R.id.listview2);
        listView2.setAdapter(SP2);

        //listview点击事件
//        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                imageView2 = (ImageView) zhangziyang.findViewById(R.id.image2);
//                switch (position){
//                    case 0:
//                        add(0);
//                        break;
//                    case 1:
//                        add(1);
//                        break;
//                    case 2:
//                        add(2);
//                        break;
//
//                }
//            }
//        });

        //zzy_button
        imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
