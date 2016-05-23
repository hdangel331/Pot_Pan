package com.example.ziyang.potpan.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.Data.zzy_data;
import com.example.ziyang.potpan.Login.cll_exit;
import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.util.SocketClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import static com.example.ziyang.potpan.Data.zzy_constants.*;
/*
*Created by jingye.hong
*1301034
*/
public class Library extends Activity {

    private Handler myHandler;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Library);
        listView = (ListView) findViewById(R.id.list);
        cll_exit.getInstance().addActivity(this);

        //Get Account
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String ACCOUNT = bundle.getString("account");

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer submitContent = new StringBuffer();
                submitContent.append(GET_LIB);
                SocketClient.ConnectSevert(submitContent.toString());
                String readinfo = SocketClient.readinfo;
                Message message = new Message();
                message.obj = readinfo;
                message.what = 1;
                myHandler.sendMessage(message);
            }
        }).start();
        //set list item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String[] Name = zzy_data.getF();
                        String[] Url = zzy_data.getG();

                        StringBuffer submitContent = new StringBuffer();
                        submitContent.append(ADD_RECIPEFROMLIB + ACCOUNT + ADD_RECIPEFROMLIB + Name[position] + ADD_RECIPEFROMLIB + Url[position]);
                        SocketClient.ConnectSevert(submitContent.toString());
                        String readinfo = SocketClient.readinfo;
                        if (readinfo.equals("ok")) {
                            Message message = new Message();
                            message.what = 2;
                            myHandler.sendMessage(message);
                        } else {
                            Message message = new Message();
                            message.what = 3;
                            myHandler.sendMessage(message);
                        }
                    }
                }).start();
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
                        String[] name = new String[list.size()];
                        String[] url = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            String[] str = list.get(i);
                            name[i] = str[0];
                            url[i] = str[1];
                            System.out.println(str[0]);
                            System.out.println(str[1]);
                        }
                        zzy_data.setF(name);
                        zzy_data.setG(url);

                        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(Library.this).build();
                        ImageLoader.getInstance().init(config);
                        listView.setAdapter(new ListViewAdapter(Library.this));
                        break;
                    case 2:
                        Intent intent = new Intent();
                        intent.putExtra("useraccount", ACCOUNT);
                        intent.setClass(Library.this, wxx_main.class);
                        startActivity(intent);
                        Library.this.finish();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "This recipe already exists.",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
                super.handleMessage(msg);
            }
        };

    }

    private static class ListViewAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private static String[] library = zzy_data.getG();
        private static String[] name = zzy_data.getF();
        private DisplayImageOptions options;

        ListViewAdapter(Context context) {
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
            return library.length;
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
                view = inflater.inflate(R.layout.LibraryItem, parent, false);
                holder = new ViewHolder();
                holder.imageview = (ImageView) view.findViewById(R.id.img);
                holder.textview = (TextView) view.findViewById(R.id.title);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();

            }
            holder.textview.setText(name[position]);
            ImageLoader.getInstance().displayImage(library[position], holder.imageview, options);
            return view;
        }

        static class ViewHolder {
            ImageView imageview;
            TextView textview;
        }
    }
}
