package com.zb.designpattern.strategy;

/**
 * Created by zhangbin on 2018/8/23.
 */
public class VipPlayer implements Player {
    @Override
    public double getMoney(double originMoney) {
        return originMoney * 0.9;
    }
}
