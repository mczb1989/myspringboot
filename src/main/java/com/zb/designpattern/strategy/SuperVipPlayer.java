package com.zb.designpattern.strategy;

/**
 * Created by zhangbin on 2018/8/23.
 */
public class SuperVipPlayer implements Player {
    @Override
    public double getMoney(double originMoney) {
        return originMoney * 0.6;
    }
}
