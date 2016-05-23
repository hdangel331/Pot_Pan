package com.example.ziyang.potpan.Main;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.Data.zzy_data;
import com.example.ziyang.potpan.Info.wxx_AboutUs22;
import com.example.ziyang.potpan.Info.wxx_example;
import com.example.ziyang.potpan.Info.wxx_feedback;
import com.example.ziyang.potpan.Login.cll_exit;
import com.example.ziyang.potpan.Login.cll_main;
import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.util.SocketClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

import static com.example.ziyang.potpan.Data.zzy_constants.*;

public class wxx_main extends Activity {

    private GridView gridview;
    private Button buttonlast;
    private Context mContext = null;
    private Handler myHandler;
    private Thread thread1;
    private Thread thread2;
    private ImageAdapter imageAdapter;
    private GifImageView loading1;

    private ListView listview;
    private ArrayList<String> menulist;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_main);

        //get account
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String ACCOUNT = bundle.getString("useraccount");
        zzy_data.setA(ACCOUNT);

        loading1 = (GifImageView) findViewById(R.id.loading1);
        gridview = (GridView) findViewById(R.id.gridview);
        mContext = this;
        buttonlast = (Button) findViewById(R.id.ButtonLast);

        loading1.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                loading1.setVisibility(View.INVISIBLE);
            }
        }, 1000);
        buttonlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);
            }
        });
        cll_exit.getInstance().addActivity(this);

        listview = (ListView) findViewById(R.id.left_drawer);
        menulist = new ArrayList<String>();
        menulist.add("About Pot&Pan");//Functions
        menulist.add("Help");//界面搞完截图弄上去,how to use this app
        menulist.add("Feedback");
        menulist.add("Log out");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menulist);
        listview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loading1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        loading1.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
                String[] Name = zzy_data.getB();
                Intent intent = new Intent();
                intent.putExtra("recipename", Name[position]);
                intent.putExtra("position", position);
                intent.setClass(wxx_main.this, zzy_main.class);
                startActivity(intent);
            }
        });

        gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showLongPopupWindow(view, position);
                return true;
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent();
                        intent.setClass(wxx_main.this, wxx_AboutUs22.class);
                        startActivity(intent);
                        wxx_main.this.finish();
                        break;
                    case 1:
                        Intent intent1 = new Intent();
                        intent1.setClass(wxx_main.this, wxx_example.class);
                        startActivity(intent1);
                        wxx_main.this.finish();
                        break;
                    case 2:
                        Intent intent2 = new Intent();
                        intent2.setClass(wxx_main.this, wxx_feedback.class);
                        startActivity(intent2);
                        wxx_main.this.finish();
                        break;
                    case 3:
                        Intent intent3 = new Intent();
                        intent3.setClass(wxx_main.this, cll_main.class);
                        startActivity(intent3);
                        wxx_main.this.finish();
                        break;
                }
            }
        });
    }

    private void showPopupWindow(View view) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.PlusPopupWindowLayout, null);
        Button designRecipe = (Button) contentView.findViewById(R.id.deg);
        Button addRecipe = (Button) contentView.findViewById(R.id.lib);
        designRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        loading1.setVisibility(View.INVISIBLE);
                    }
                }, 500);
                Intent intent = new Intent();
                intent.putExtra("recipename", "");
                intent.putExtra("accountname", zzy_data.getA());
                intent.setClass(wxx_main.this, DesignRecipe.class);
                startActivity(intent);
                wxx_main.this.finish();
            }
        });
        addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        loading1.setVisibility(View.INVISIBLE);
                    }
                }, 500);
                Intent intent = new Intent();
                intent.putExtra("account", zzy_data.getA());
                intent.setClass(wxx_main.this, Library.class);
                startActivity(intent);
                wxx_main.this.finish();
                onDestroy();
            }
        });
        final PopupWindow popupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    private void showLongPopupWindow(View view, final int position) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.LongPressPopupWindowLayout, null);
        Button editRecipe = (Button) contentView.findViewById(R.id.edtExist);
        Button deleteRecipe = (Button) contentView.findViewById(R.id.del);
        editRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        loading1.setVisibility(View.INVISIBLE);
                    }
                }, 500);
                String[] Name = zzy_data.getB();
                Intent intent = new Intent();
                intent.putExtra("recipename", Name[position]);
                intent.putExtra("accountname", zzy_data.getA());
                intent.setClass(wxx_main.this, DesignRecipe.class);
                startActivity(intent);
                wxx_main.this.finish();
            }
        });
        deleteRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String[] Name = zzy_data.getB();
                        StringBuffer submitContent = new StringBuffer();
                        submitContent.append(DELETE_RECIPE + zzy_data.getA() + DELETE_RECIPE + Name[position]);
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
                });
                thread2.start();
            }
        });
        final PopupWindow popupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    //GridView adapter
    private static class ImageAdapter extends BaseAdapter {

        private static String[] Recipes;
        private static String[] Name;
        private LayoutInflater inflater;
        private DisplayImageOptions options;

        public ImageAdapter(String[] recipe, String[] name, Context context) {
            Recipes = recipe;
            Name = name;
            inflater = LayoutInflater.from(context);
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.zzy_loading)
                    .showImageForEmptyUri(R.drawable.zzy_empty)
                    .showImageOnFail(R.drawable.zzy_fail)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                    .build();
        }

        public void refresh(String[] recipe, String[] name) {
            Recipes = recipe;
            Name = name;
        }

        @Override
        public int getCount() {
            return Recipes.length;
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
            final ViewHolder holder;
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.wxx_gridview, parent, false);
                holder = new ViewHolder();
                assert view != null;
                holder.imageview = (ImageView) view.findViewById(R.id.recipe);
                holder.textview = (TextView) view.findViewById(R.id.recipename);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.textview.setText(Name[position]);
            ImageLoader.getInstance().displayImage(Recipes[position], holder.imageview, options, new SimpleImageLoadingListener());

            return view;
        }
    }

    static class ViewHolder {
        ImageView imageview;
        TextView textview;
    }


    @Override
    protected void onResume() {
        super.onResume();

        //Add adapter
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(wxx_main.this).build();
        ImageLoader.getInstance().init(config);
        imageAdapter = new ImageAdapter(zzy_data.getC(), zzy_data.getB(), wxx_main.this);
        gridview.setAdapter(imageAdapter);

        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer submitContent = new StringBuffer();
                submitContent.append(GET_RECIPEBYACCOUNT + zzy_data.getA());
                SocketClient.ConnectSevert(submitContent.toString());
                String readinfo = SocketClient.readinfo;
                Message message = new Message();
                message.obj = readinfo;
                message.what = 1;
                myHandler.sendMessage(message);
            }
        });
        thread1.start();

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        System.out.println("case1");
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
                        }
                        zzy_data.setB(name);
                        zzy_data.setC(url);
                        imageAdapter.refresh(zzy_data.getC(), zzy_data.getB());
                        imageAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Delete Success",
                                Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent();
                                intent.setClass(wxx_main.this, wxx_main.class);
                                intent.putExtra("useraccount", zzy_data.getA());
                                startActivity(intent);
                                wxx_main.this.finish();
                            }
                        }, 500);
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Delete Fail",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
                super.handleMessage(msg);
            }
        };
    }
}
