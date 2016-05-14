package com.example.ziyang.potpan;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxx on 2016/5/4.
 */












public class wxx_AboutUsActivity extends Activity {

    private View view1, view2, view3;
    private List<View> viewList;//view数组
    private ViewPager viewPager;  //对应的viewPager
    private Button vpback;//对应第三张图里那个Back按钮
    private ImageView cursor;
    private int bmpw = 0; // 游标宽度
    private int offset = 0;// // 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wxx_vp);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.wxx_vpbg1, null);
        view2 = inflater.inflate(R.layout.wxx_vpbg2,null);
        view3 = inflater.inflate(R.layout.wxx_vpbg3, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

////初始化指示器位置
//        initCursorPos();
//
//        viewPager.setAdapter(new MyPagerAdapter(viewList));
//        viewPager.setOnPageChangeListener(new MyPageChangeListener());
//
//    }


//    //初始化指示器位置
//    public void initCursorPos() {
//        // 初始化动画
//        cursor = (ImageView) findViewById(R.id.cursor);
//        bmpw = BitmapFactory.decodeResource(getResources(), R.drawable.wxx_a)
//                .getWidth();// 获取图片宽度
//
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenW = dm.widthPixels;// 获取分辨率宽度
//        offset = (screenW / viewList.size() - bmpw) / 2;// 计算偏移量
//
//        Matrix matrix = new Matrix();
//        matrix.postTranslate(offset, 0);
//        cursor.setImageMatrix(matrix);// 设置动画初始位置
//    }
//
//
//
//    //页面改变监听器
//    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
//
//        int one = offset * 2 + bmpw;// 页卡1 -> 页卡2 偏移量
//        int two = one * 2;// 页卡1 -> 页卡3 偏移量
//
//        @Override
//        public void onPageSelected(int arg0) {
//            Animation animation = null;
//            switch (arg0) {
//                case 0:
//                    if (currIndex == 1) {
//                        animation = new TranslateAnimation(one, 0, 0, 0);
//                    } else if (currIndex == 2) {
//                        animation = new TranslateAnimation(two, 0, 0, 0);
//                    }
//                    break;
//                case 1:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, one, 0, 0);
//                    } else if (currIndex == 2) {
//                        animation = new TranslateAnimation(two, one, 0, 0);
//                    }
//                    break;
//                case 2:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, two, 0, 0);
//                    } else if (currIndex == 1) {
//                        animation = new TranslateAnimation(one, two, 0, 0);
//                    }
//                    break;
//            }
//            currIndex = arg0;
//            animation.setFillAfter(true);// True:图片停在动画结束位置
//            animation.setDuration(300);
//            cursor.startAnimation(animation);
//        }
//
//        @Override
//        public void onPageScrolled(int arg0, float arg1, int arg2) {
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int arg0) {
//        }
//    }



        PagerAdapter pagerAdapter = new PagerAdapter() {


            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }



            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }




            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }


//        };



















    };



        viewPager.setAdapter(pagerAdapter);


}}
