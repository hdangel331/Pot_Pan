package com.example.ziyang.potpan;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by Ziyang on 2016/4/15.
 */
public class wxx_main extends Activity {

    private GridView gridview;
    private Button buttonlast;
    private Context mContext = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wxx_main);
        mContext = this;
        buttonlast = (Button) findViewById(R.id.ButtonLast);
        buttonlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);
            }
        });

        //初始化
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, zzy_main.class);
                startActivity(intent);
            }
        });

        //在这里写长按事件
        gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });

    }

    private void showPopupWindow(View view) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.hjy_popuplayout, null);
        Button button = (Button) contentView.findViewById(R.id.edt);
        Button thebutton = (Button) contentView.findViewById(R.id.lib);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, hjy_main.class);
                startActivity(intent);
            }
        });
        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(wxx_main.this, hjy_lib.class);
                startActivity(intent);
            }
        });
        final PopupWindow popupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }


    //GridView适配器
    private static class ImageAdapter extends BaseAdapter {

        private static final String[] Recipes = zzy_constants.RECIPE;
        private LayoutInflater inflater;
        private DisplayImageOptions options;

        ImageAdapter(Context context) {
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
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            ImageLoader.getInstance().displayImage(Recipes[position], holder.imageview, options, new SimpleImageLoadingListener());
            return view;
        }
    }

    static class ViewHolder {
        ImageView imageview;
    }
}
