package com.zb.designpattern.abstractfactory;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class DogFactory implements IFactory {
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
