package com.zb.designpattern.observe;

/**
 * Created by zhangbin on 2018/8/23.
 */
public interface ToObserver {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
