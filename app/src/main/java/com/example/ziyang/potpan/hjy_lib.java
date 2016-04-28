package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

public class hjy_lib extends Activity {
//    String[] titles = { "hongshaorou", "hongshaodoufu", "zheergen", "chaocai", "wawacai", "qiezi", "liangbanmuer" };
//    int[] resIds = { R.drawable.hongshaorou, R.drawable.hongshaodoufu, R.drawable.zheergen, R.drawable.chaocai, R.drawable.wawacai,
//            R.drawable.qiezi, R.drawable.liangbanmuer };
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjy_fromlib);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ListViewAdapter(this));
    }

    private static class ListViewAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private static final String[] library = zzy_constants.library;
        private static final String[] name = new String[]{"diyige","dierge","disange","disige","diwuge","diliuge","diqige","dibage"};
//        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

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
//            ImageLoader.getInstance().displayImage(IMAGE_URLS[position],holder.imageview,options,animateFirstListener);
            return view;
        }

        static class ViewHolder {
            ImageView imageview;
            TextView textview;
        }
    }



//
//    public class ListViewAdapter extends BaseAdapter {
//        View[] itemViews;
//
//        public ListViewAdapter(String[] itemTitles, int[] itemImageRes) {
//            itemViews = new View[itemTitles.length];
//
//            for (int i = 0; i < itemViews.length; i++) {
//                itemViews[i] = makeItemView(itemTitles[i], itemImageRes[i]);
//            }
//        }
//
//        public int getCount() {
//            return itemViews.length;
//        }
//
//        public View getItem(int position) {
//            return itemViews[position];
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        private View makeItemView(String strTitle, int resId) {
//            LayoutInflater inflater = (LayoutInflater) hjy_lib.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            // 使用View的对象itemView与R.layout.item关联
//            View itemView = inflater.inflate(R.layout.hjy_listitem, null);
//
//            // 通过findViewById()方法实例R.layout.item内各组件
//            TextView title = (TextView) itemView.findViewById(R.id.title);
//            title.setText(strTitle);
//            ImageView image = (ImageView) itemView.findViewById(R.id.img);
//            image.setImageResource(resId);
//
//            return itemView;
//        }
//
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null)
//                return itemViews[position];
//            return convertView;
//        }
//    }

}
