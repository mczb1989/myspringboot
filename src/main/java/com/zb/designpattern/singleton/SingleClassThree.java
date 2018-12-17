package com.zb.designpattern.singleton;

/**
 * Created by zhangbin on 2018/8/21.
 */
public enum SingleClassThree {
    Single;

    //readResolve to prevent another instance of Singleton
    private Object readResolve(){
        return Single;
    }

}
