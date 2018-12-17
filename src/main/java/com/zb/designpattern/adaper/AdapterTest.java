package com.zb.designpattern.adaper;

/**
 * Created by zhangbin on 2018/8/22.
 */
public class AdapterTest {

    public static void main(String[] args){
        AdaInterface adaInterface = new Adapter();
        adaInterface.method1();
        adaInterface.method2();
    }
}
