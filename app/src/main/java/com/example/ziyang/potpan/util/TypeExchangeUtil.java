package com.example.ziyang.potpan.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyang on 2016/5/14.
 */
public class TypeExchangeUtil {
    public static List<String> liststring(String str) {
        List<String> list = new ArrayList<String>();
        String[] getmsg = str.split("#");
        for (int i = 0; i < getmsg.length; i++) {
            list.add(getmsg[i]);
        }
        return list;
    }
}
