package com.example.ziyang.potpan.Main;

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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.ziyang.potpan.DATABASE.MaterialDB;
import com.example.ziyang.potpan.DATABASE.SeasoningDB;
import com.example.ziyang.potpan.Data.zzy_data;
import com.example.ziyang.potpan.Login.cll_exit;
import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.util.SocketClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import static com.example.ziyang.potpan.Data.zzy_constants.*;

public class zzy_main extends Activity implements View.OnTouchListener {

    private ListView listView1, listView2;
    private ImageButton start, empty;
    private GifImageView white, loading;

    private Handler myHandler;
    private int screenWidth, screenHeight;
    private int lastX, lastY;

    private static String[] Material = new String[]{};
    private static String[] Seasoning = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzy_main);
        cll_exit.getInstance().addActivity(this);
        listView1 = (ListView) findViewById(R.id.listview1);
        listView2 = (ListView) findViewById(R.id.listview2);
        start = (ImageButton) findViewById(R.id.start);
        empty = (ImageButton) findViewById(R.id.empty);
        white = (GifImageView) findViewById(R.id.white);
        loading = (GifImageView) findViewById(R.id.loading);

        Display dis = this.getWindowManager().getDefaultDisplay();
        screenWidth = dis.getWidth();
        screenHeight = dis.getHeight();

        //get account
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String RecipeName = bundle.getString("recipename");
        final int position = bundle.getInt("position") + 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer submitContent = new StringBuffer();
                submitContent.append(GET_CONTENTBYNAME + RecipeName);
                SocketClient.ConnectSevert(submitContent.toString());
                String readinfo = SocketClient.readinfo;
                Message message = new Message();
                message.obj = readinfo;
                message.what = 1;
                myHandler.sendMessage(message);
            }
        }).start();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loading.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.setVisibility(View.INVISIBLE);
                        switch (position) {
                            case 10:
                                Intent intent1 = new Intent();
                                intent1.setClass(zzy_main.this, cll_f1.class);
                                startActivity(intent1);
                                zzy_main.this.finish();
                                break;
                            case 11:
                                Intent intent2 = new Intent();
                                intent2.setClass(zzy_main.this, cll_f2.class);
                                startActivity(intent2);
                                zzy_main.this.finish();
                                break;
                        }
                    }
                }, 3000);
            }
        });

        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(zzy_main.this, zzy_main.class);
                intent.putExtra("recipename", RecipeName);
                intent.putExtra("position", position - 10);
                startActivity(intent);
                zzy_main.this.finish();
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Pos, long id) {
                Message message = new Message();
                message.obj = Pos;
                message.what = 2;
                myHandler.sendMessage(message);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                white.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        white.setVisibility(View.INVISIBLE);
                    }
                }, 2500);
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

                        //MaterialDB get
                        MaterialDB materialdb = new MaterialDB(zzy_main.this);
                        SQLiteDatabase materialread = materialdb.getReadableDatabase();

                        //SeasoningDB get
                        SeasoningDB seasoningdb = new SeasoningDB(zzy_main.this);
                        SQLiteDatabase seasoningread = seasoningdb.getReadableDatabase();

                        //Material read
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

                        //Material read
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

                        //Add adapter
                        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(zzy_main.this).build();
                        ImageLoader.getInstance().init(config);
                        listView1.setAdapter(new ImageAdapter1(zzy_main.this));
                        listView2.setAdapter(new ImageAdapter2(zzy_main.this));
                        break;
                    case 2:
                        int pos = (int) msg.obj;
                        String[] materialname = zzy_data.getD();
                        String prefix = materialname[pos];
                        String postfix = ".gif";
                        String name = prefix + postfix;
                        try {
                            RelativeLayout process = (RelativeLayout) findViewById(R.id.processLayout);
                            RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            Random random = new Random();
                            lp1.leftMargin = random.nextInt(430);
                            lp1.topMargin = random.nextInt(350);
                            GifDrawable gifdrawable = new GifDrawable(getAssets(), name); // Only if it exists in assets file
                            GifImageView gif = new GifImageView(zzy_main.this);
                            gif.setImageDrawable(gifdrawable);
                            process.addView(gif, lp1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                if (top >= screenHeight) {
                    top = screenHeight;
                }
                if (left >= screenWidth) {
                    left = screenWidth;
                }
                if (left <= 0) {
                    left = 0;
                }
                v.layout(left, top, left, top);
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }


    //First Adapter
    private static class ImageAdapter1 extends BaseAdapter {

        private LayoutInflater inflater;
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
            return view;
        }
    }

    //Second Adapter
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
            return view;
        }
    }

    static class ViewHolder {
        ImageView imageview;
    }
}
