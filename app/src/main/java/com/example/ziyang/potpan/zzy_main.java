package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ziyang.potpan.DATABASE.MaterialDB;
import com.example.ziyang.potpan.DATABASE.SeasoningDB;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class zzy_main extends Activity {

    private ListView listView1, listView2;
    private ImageButton imageButton1;

    private static String[] Material = new String[]{};
    private static String[] Seasoning = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzy_main);
        cll_exit.getInstance().addActivity(this);

        //MaterialDB 获取
        MaterialDB materialdb = new MaterialDB(this, "materialdb", null, 1);
        SQLiteDatabase materialread = materialdb.getReadableDatabase();

        //SeasoningDB 获取
        SeasoningDB seasoningdb = new SeasoningDB(this, "seasoningdb", null, 1);
        SQLiteDatabase seasoningread = seasoningdb.getReadableDatabase();

        //Material 读取
        List<String> list1 = new ArrayList<String>();
        Cursor c1 = materialread.query("MaterialDB", new String[]{"materialurl"}, null, null, null, null, null);
        while (c1.moveToNext()) {
            String a = c1.getString(c1.getColumnIndex("materialurl"));
            list1.add(a);
        }
        Material = list1.toArray(new String[list1.size()]);
        c1.close();

        //Material 读取
        List<String> list2 = new ArrayList<String>();
        Cursor c2 = seasoningread.query("SeasoningDB", new String[]{"seasoningurl"}, null, null, null, null, null);
        while (c2.moveToNext()) {
            String b = c2.getString(c2.getColumnIndex("seasoningurl"));
            list2.add(b);
        }
        Seasoning = list2.toArray(new String[list2.size()]);
        c2.close();

        //初始化
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        //放入ListView1
        listView1 = (ListView) findViewById(R.id.listview1);
        listView1.setAdapter(new ImageAdapter1(this));

        //放入ListView1
        listView2 = (ListView) findViewById(R.id.listview2);
        listView2.setAdapter(new ImageAdapter2(this));


        //zzy_button
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    //第一个适配器！！！
    private static class ImageAdapter1 extends BaseAdapter {

        private LayoutInflater inflater;
//        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

        private DisplayImageOptions options;


        ImageAdapter1(Context context) {
            inflater = LayoutInflater.from(context);
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.zzy_loading)
                    .showImageOnFail(R.drawable.zzy_fail)
                    .showImageForEmptyUri(R.drawable.zzy_empty)
                    .cacheOnDisk(true)
                    .cacheInMemory(true)
                    .considerExifParams(true)
                    .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                    .build();
        }

        public int getCount() {
            return Material.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder holder;

            if (convertView == null) {
                view = inflater.inflate(R.layout.zzy_image1, parent, false);
                holder = new ViewHolder();
                holder.imageview = (ImageView) view.findViewById(R.id.image1);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            ImageLoader.getInstance().displayImage(Material[position], holder.imageview, options);
//            ImageLoader.getInstance().displayImage(IMAGE_URLS[position],holder.imageview,options,animateFirstListener);
            return view;
        }
    }

    static class ViewHolder {
        ImageView imageview;
    }

//    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
//
//        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
//
//        @Override
//        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//            if (loadedImage != null) {
//                ImageView imageView = (ImageView) view;
//                boolean firstDisplay = !displayedImages.contains(imageUri);
//                if (firstDisplay) {
//                    FadeInBitmapDisplayer.animate(imageView, 500);
//                    displayedImages.add(imageUri);
//                }
//            }
//        }
//    }


    //第二个适配器！！！
    private static class ImageAdapter2 extends BaseAdapter {

        private LayoutInflater inflater;
//        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

        private DisplayImageOptions options;


        ImageAdapter2(Context context) {
            inflater = LayoutInflater.from(context);
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.zzy_loading)
                    .showImageOnFail(R.drawable.zzy_fail)
                    .showImageForEmptyUri(R.drawable.zzy_empty)
                    .cacheOnDisk(true)
                    .cacheInMemory(true)
                    .considerExifParams(true)
                    .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                    .build();
        }

        public int getCount() {
            return Seasoning.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder holder;

            if (convertView == null) {
                view = inflater.inflate(R.layout.zzy_image2, parent, false);
                holder = new ViewHolder();
                holder.imageview = (ImageView) view.findViewById(R.id.image2);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            ImageLoader.getInstance().displayImage(Seasoning[position], holder.imageview, options);
//            ImageLoader.getInstance().displayImage(IMAGE_URLS[position],holder.imageview,options,animateFirstListener);
            return view;
        }
    }

}
