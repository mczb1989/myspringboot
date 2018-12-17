package com.zb.designpattern.factory;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class FactoryOne {
    public static Productor getProdutor(){
        return new Productor();
    }
    public static Potato getPotato(){
        return new Potato();
    }
}
