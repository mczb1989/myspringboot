package com.zb.designpattern.strategy;

/**
 * Created by zhangbin on 2018/8/23.
 */
public class Buyer {
    Player player = new OriginPlayer();
    double totalMount = 0;

    public double buy(double price){
        totalMount = totalMount + price;
        if(totalMount > 5000)
            player = new VipPlayer();
        if(totalMount > 10000)
            player = new SuperVipPlayer();

        return player.getMoney(price);
    }
}
