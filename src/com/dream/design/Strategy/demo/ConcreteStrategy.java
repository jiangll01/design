package com.dream.design.Strategy.demo;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:47
 * @Description: 具体的策略实现
 */
public class ConcreteStrategy implements IStrategy {
    @Override
    public void algorithmMethod() {
        System.out.println("this is ConcreteStrategy method...");
    }
}
