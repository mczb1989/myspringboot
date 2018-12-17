package com.zb.designpattern.build;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class Director {
    public static void main(String[] args){
        Person person = BuildClass.createBuild()
                .buildHead("tou")
                .buildBody("shenti")
                .buildFoot("jiao")
                .build();
    }
}
