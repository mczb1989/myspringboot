package com.zb.designpattern.singleton;

/**
 * 饱汉模式
 *
 * Created by zhangbin on 2018/8/21.
 */
public class SingleClassOne {

    private static SingleClassOne singleClassOne = new SingleClassOne();

    private SingleClassOne(){}

    public static SingleClassOne getSingle(){
        return singleClassOne;
    }
}
