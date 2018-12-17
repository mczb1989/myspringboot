package com.zb.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by zhangbin on 2018/8/22.
 */
public class ProxyTest {
    public static void main(String[] args){
        ProxyLocalInterface local = new ProxyLocalClass();
        ProxyLocalInterface proxy = (ProxyLocalInterface)Proxy.newProxyInstance(ProxyLocalInterface.class.getClassLoader(), new Class[]{ProxyLocalInterface.class}, new DynamicProxyHandler(local));
        proxy.sayHello();
    }
}
