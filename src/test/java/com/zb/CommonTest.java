package com.zb;

import java.util.Calendar;

/**
 * Created by zhangbin on 2018/8/23.
 */
public class CommonTest {
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        long l = 1535408670975L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        System.out.println(calendar.getTime());

        String[] rs = new String[9];
    }
}
