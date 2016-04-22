package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class hjy_lib extends Activity {
    String[] titles = { "hongshaorou", "hongshaodoufu", "zheergen", "chaocai", "wawacai", "qiezi", "liangbanmuer" };
    int[] resIds = { R.drawable.hongshaorou, R.drawable.hongshaodoufu, R.drawable.zheergen, R.drawable.chaocai, R.drawable.wawacai,
            R.drawable.qiezi, R.drawable.liangbanmuer };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjy_fromlib);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ListViewAdapter(titles, resIds));
    }

    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(String[] itemTitles, int[] itemImageRes) {
            itemViews = new View[itemTitles.length];

            for (int i = 0; i < itemViews.length; i++) {
                itemViews[i] = makeItemView(itemTitles[i], itemImageRes[i]);
            }
        }

        public int getCount() {
            return itemViews.length;
        }

        public View getItem(int position) {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(String strTitle, int resId) {
            LayoutInflater inflater = (LayoutInflater) hjy_lib.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.hjy_listitem, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView) itemView.findViewById(R.id.title);
            title.setText(strTitle);
            ImageView image = (ImageView) itemView.findViewById(R.id.img);
            image.setImageResource(resId);

            return itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }
}
