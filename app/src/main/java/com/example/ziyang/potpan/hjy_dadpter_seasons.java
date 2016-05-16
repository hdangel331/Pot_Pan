package com.example.ziyang.potpan;

import android.content.Context;

import android.view.View;

import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.widget.Gallery;

import android.widget.ImageView;

public class hjy_dadpter_seasons extends BaseAdapter {
    private Context ctx;
    private int[] images = {
            R.drawable.hjy_s_chilli,
            R.drawable.hjy_s_cinnamon,
            R.drawable.hjy_s_cumin,
            R.drawable.hjy_s_curry,
            R.drawable.hjy_s_garlic,
            R.drawable.hjy_s_ginger,
            R.drawable.hjy_s_onion,
            R.drawable.hjy_s_rosemary,
            R.drawable.hjy_s_salt,
            R.drawable.hjy_s_shallot,
            R.drawable.hjy_s_soysauce,
            R.drawable.hjy_s_staranise,
            R.drawable.hjy_s_sugar,
            R.drawable.hjy_s_tsaoko,};

    public hjy_dadpter_seasons(Context ctx)
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

        ImageView view = (ImageView) convertView;
        if (view == null )
        {
            view = new ImageView( ctx );
        }
        view.setImageResource( images [position]);

        view.setLayoutParams( new Gallery.LayoutParams(300, 300));

        view.setScaleType(ImageView.ScaleType. CENTER_INSIDE );
        return view;
    }
}