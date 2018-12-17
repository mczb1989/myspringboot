package com.zb.designpattern.proxy;

/**
 * Created by zhangbin on 2018/8/22.
 */
public class ProxyLocalClass implements ProxyLocalInterface {
    @Override
    public void sayHello() {
        System.out.println("hhelo");
    }
}
