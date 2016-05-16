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
            R.drawable.hjy_bacon,
            R.drawable.hjy_balsampear,
            R.drawable.hjy_beef,
            R.drawable.hjy_carrot,
            R.drawable.hjy_celery,
            R.drawable.hjy_checken,
            R.drawable.hjy_checkenbreast,
            R.drawable.hjy_chinesecabbage,
            R.drawable.hjy_corn,
            R.drawable.hjy_drumstick,
            R.drawable.hjy_egg,
            R.drawable.hjy_eggplant,
            R.drawable.hjy_fish,
            R.drawable.hjy_leek,
            R.drawable.hjy_lettuce,
            R.drawable.hjy_loveapple,
            R.drawable.hjy_mushroom,
            R.drawable.hjy_potapo,
            R.drawable.hjy_pumpkin,
            R.drawable.hjy_rice,
            R.drawable.hjy_shrimp, };

    public hjy_adapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return images[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = (ImageView) convertView;
        if (view == null) {
            view = new ImageView(ctx);
        }
        view.setImageResource(images[position]);
        view.setLayoutParams(new Gallery.LayoutParams(300, 300));
        view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return view;
    }
}