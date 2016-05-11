package com.example.ziyang.potpan;

import android.content.Context;

import android.view.View;

import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.widget.Gallery;

import android.widget.ImageView;

public class hjy_adapter extends BaseAdapter {
    private Context ctx;
    private int[] images = {
            R.drawable.hjy_1,
            R.drawable.hjy_2,
            R.drawable.hjy_3,
            R.drawable.hjy_4,
            R.drawable.hjy_5,
            R.drawable.hjy_6,
            R.drawable.hjy_7,
            R.drawable.hjy_8,
            R.drawable.hjy_9,};

    public hjy_adapter(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public int getCount()
    {
        return images . length ;
    }
    @Override
    public Object getItem( int position)
    {
        return images [position];
    }
    @Override
    public long getItemId( int position)
    {
        return images [position];
    }
    @Override
    public View getView( int position, View convertView, ViewGroup parent)
    {
        // 将 convertView 赋给 view
        ImageView view = (ImageView) convertView;
        if (view == null )                             // 如果 view 为空
        {
            view = new ImageView( ctx );     // 就新建一个
        }
        // 否则就是用已经存在的 convertView 。
        // 上面做法可以大幅度提高程序运行性能 ， 也可以减少内存的使用 ， 尤其在 Gallery 对象
        // 中有很多 item 的时候
        // 设定显示图片
        view.setImageResource( images [position]);
        // 设定每个图片的显示大小
        view.setLayoutParams( new Gallery.LayoutParams(160, 160));
        //view.setScaleType(ImageView.ScaleType.FIT_XY);
        // 这个是维持图片原始大小
        // 设定图片缩放：即在上面规定的大小中进行显示，并且居中
        view.setScaleType(ImageView.ScaleType. CENTER_INSIDE );
        return view;
    }
}