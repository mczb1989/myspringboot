package com.zb.designpattern.singleton;

/**
 * 恶汉模式
 * Created by zhangbin on 2018/8/21.
 */
public class SingleClassTwo {

    private static SingleClassTwo singleClassTwo = null;

    private SingleClassTwo(){}

    public static SingleClassTwo getSingle(){
        if(singleClassTwo == null){
            synchronized ("lock"){
                if(singleClassTwo == null){
                    singleClassTwo = new SingleClassTwo();
                }
            }
        }
        return singleClassTwo;
    }
}
