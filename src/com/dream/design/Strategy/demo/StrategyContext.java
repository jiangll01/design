package com.dream.design.Strategy.demo;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:49
 * @Description: 策略上下文
 */
public class StrategyContext {
    //持有一个策略实现的引用
    private IStrategy iStrategy;

    public StrategyContext(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void contextMethod() {
        //调用策略实现的方法
        iStrategy.algorithmMethod();
    }
}

