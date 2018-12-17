package com.zb.designpattern.abstractfactory;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class AbstractFactoryTestClass {

    public static void main(String[] args){
        IFactory iFactory = new DogFactory();
        iFactory.getAnimal();
    }
}
