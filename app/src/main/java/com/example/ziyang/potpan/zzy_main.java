package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.ziyang.potpan.DATABASE.MaterialDB;
import com.example.ziyang.potpan.DATABASE.SeasoningDB;
import com.example.ziyang.potpan.util.SocketClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

import static com.example.ziyang.potpan.zzy_constants.*;

public class zzy_main extends Activity implements View.OnTouchListener {

    private ListView listView1, listView2;
    private Handler myHandler;
    int screenWidth, screenHeight;
    int lastX, lastY;
    private ImageView image;
    private GifImageView white;

    private static String[] Material = new String[]{};
    private static String[] Seasoning = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzy_main);
        cll_exit.getInstance().addActivity(this);
        listView1 = (ListView) findViewById(R.id.listview1);
        listView2 = (ListView) findViewById(R.id.listview2);

        Display dis = this.getWindowManager().getDefaultDisplay();
        screenWidth = dis.getWidth();
        screenHeight = dis.getHeight();

        //获取账户
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String RecipeName = bundle.getString("recipename");

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer submitContent = new StringBuffer();//定义服务器
                submitContent.append(GET_CONTENTBYNAME + RecipeName);//将信息添加到字符串中
                SocketClient.ConnectSevert(submitContent.toString());//将信息传给服务器
                String readinfo = SocketClient.readinfo;
                Message message = new Message();
                message.obj = readinfo;
                message.what = 1;
                myHandler.sendMessage(message);
            }
        }).start();

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RelativeLayout processLayout = (RelativeLayout) findViewById(R.id.processLayout);
                image = new ImageView(zzy_main.this);
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage("http://i2.buimg.com/ccebf2760ee5ec39.png", image);
                RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp1.leftMargin = 400;
                lp1.topMargin = 600;
                processLayout.addView(image, lp1);
                image.setClickable(true);
                image.setOnTouchListener(zzy_main.this);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                white = (GifImageView) findViewById(R.id.white);
                white.setVisibility(View.VISIBLE);

            }
        });

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        List<String[]> list = new ArrayList<String[]>();
                        String info = (String) msg.obj;
                        String[] str1 = info.split("#");
                        for (int i = 0; i < str1.length; i++) {
                            if (str1[i].length() > 0) {
                                list.add(str1[i].split("η"));
                            }
                        }
                        String[] material = new String[list.size()];
                        String[] seasoning = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            String[] str = list.get(i);
                            material[i] = str[0];
                            seasoning[i] = str[1];
                        }
                        zzy_data.setD(material);
                        zzy_data.setE(seasoning);
                        String[] materiallist = zzy_data.getD();
                        String[] seasoninglist = zzy_data.getE();

                        //MaterialDB 获取
                        MaterialDB materialdb = new MaterialDB(zzy_main.this, "materialdb", null, 1);
                        SQLiteDatabase materialread = materialdb.getReadableDatabase();

                        //SeasoningDB 获取
                        SeasoningDB seasoningdb = new SeasoningDB(zzy_main.this, "seasoningdb", null, 1);
                        SQLiteDatabase seasoningread = seasoningdb.getReadableDatabase();

                        //Material 读取
                        List<String> list1 = new ArrayList<String>();
                        for (int i = 0; i < materiallist.length; i++) {
                            Cursor c1 = materialread.query("MaterialDB", new String[]{"materialurl"}, "materialname=?", new String[]{materiallist[i]}, null, null, null);
                            while (c1.moveToNext()) {
                                String a = c1.getString(c1.getColumnIndex("materialurl"));
                                list1.add(a);
                            }
                            c1.close();
                        }
                        Material = list1.toArray(new String[list1.size()]);

                        //Material 读取
                        List<String> list2 = new ArrayList<String>();
                        for (int i = 0; i < seasoninglist.length; i++) {
                            Cursor c2 = seasoningread.query("SeasoningDB", new String[]{"seasoningurl"}, "seasoningname=?", new String[]{seasoninglist[i]}, null, null, null);
                            while (c2.moveToNext()) {
                                String b = c2.getString(c2.getColumnIndex("seasoningurl"));
                                list2.add(b);
                            }
                            c2.close();
                        }
                        Seasoning = list2.toArray(new String[list2.size()]);

                        //初始化
                        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(zzy_main.this).build();
                        ImageLoader.getInstance().init(config);
                        listView1.setAdapter(new ImageAdapter1(zzy_main.this));
                        listView2.setAdapter(new ImageAdapter2(zzy_main.this));

                        break;
                }
                super.handleMessage(msg);
            }
        };
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();

                break;

            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
                int top = v.getTop() + dy;
                int left = v.getLeft() + dx;

                if (top <= 0) {
                    top = 0;
                }
                if (top >= screenHeight - image.getHeight()) {
                    top = screenHeight - image.getHeight();
                }
                if (left >= screenWidth - image.getWidth()) {
                    left = screenWidth - image.getWidth();
                }

                if (left <= 0) {
                    left = 0;
                }

                v.layout(left, top, left + image.getWidth(), top + image.getHeight());
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();

                break;
            case MotionEvent.ACTION_UP:

                break;


        }
        return false;
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

    //第二个适配器！！！
    private static class ImageAdapter2 extends BaseAdapter {

        private LayoutInflater inflater;

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
