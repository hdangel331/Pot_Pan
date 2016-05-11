package com.example.ziyang.potpan;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

/**
 * Created by CandiesCLL on 2016/5/5.
 */
public class cll_exit extends Application{
    private List<Activity> activityList=new LinkedList<Activity>();

    private static cll_exit instance;

    private cll_exit()
    {
    }
    //单例模式中获取唯一的ExitApplication 实例
    public static cll_exit getInstance()
    {
        if(null == instance)
        {
            instance = new cll_exit();
        }
        return instance;

    }
    //添加Activity 到容器中
    public void addActivity(Activity activity)
    {
        activityList.add(activity);
    }
    //遍历所有Activity 并finish

    public void exit()
    {

        for(Activity activity:activityList)
        {
            activity.finish();
        }

        System.exit(0);

    }
}
