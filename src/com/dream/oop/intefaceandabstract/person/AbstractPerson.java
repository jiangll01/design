package com.dream.oop.intefaceandabstract.person;

/**
 * @author jiangll01
 * @Date: 2020/7/31 16:16
 * @Description:
 */
public abstract class AbstractPerson implements person {
    @Override
    public void eat() {
        System.out.println("人都需要吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人都需要吃饭");
    }

    @Override
    public void run() {
        System.out.println("人都需要运动");
    }
}
