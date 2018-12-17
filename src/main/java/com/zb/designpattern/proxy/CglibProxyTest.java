package com.zb.designpattern.proxy;

/**
 * Created by zhangbin on 2018/8/22.
 */
public class CglibProxyTest {
    public static void main(String[] args){
        ProxyLocalClass local = new ProxyLocalClass();
        CglibProxy cglibProxy = new CglibProxy();
        ProxyLocalClass proxy = (ProxyLocalClass) cglibProxy.getInstance(local);
        proxy.sayHello();
    }
}
