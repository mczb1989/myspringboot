package com.zb.designpattern.observe;

/**
 * Created by zhangbin on 2018/8/23.
 */
public class ObserverB implements Observer {
    @Override
    public void update(String msg) {
        System.out.println("B接收到:" + msg);
    }
}
