package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

public class hjy_lib extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjy_fromlib);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ListViewAdapter(this));
        cll_exit.getInstance().addActivity(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText ( hjy_lib.this , "Position = " + position, Toast. LENGTH_SHORT ).show();
            }
        });
    }

    private static class ListViewAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private static final String[] library = zzy_constants.library;
        private static final String[] name = new String[]{"diyige","dierge","disange","disige","diwuge","diliuge","diqige","dibage"};
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
                view = inflater.inflate(R.layout.hjy_listitem, parent, false);
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
