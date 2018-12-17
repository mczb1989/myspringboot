package com.zb.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 2018/8/23.
 */
public class TrueToObserver implements ToObserver {

    private List<Observer> list = new ArrayList<>();
    private String msg = "nihao!";

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: list) {
            o.update(msg);
        }
    }

    public void sendMsg(String msg){
        this.msg = msg;
        for (Observer o: list) {
            o.update(msg);
        }

    }
}
