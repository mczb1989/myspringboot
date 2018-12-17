package com.zb.designpattern.adaper;

/**
 * Created by zhangbin on 2018/8/22.
 */
public class Adapter extends AdaClass implements AdaInterface {

    @Override
    public void method2() {
        System.out.println(22);
    }
}
