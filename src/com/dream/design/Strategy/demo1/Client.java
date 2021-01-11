package com.dream.design.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:58
 * @Description: 这个时候，商场营销部新推出了一个客户类型--MVP用户（Most Valuable Person），
 * 可以享受折扣7折优惠，那该怎么办呢？
 * 这个很容易，只要新增一个报价策略的实现，然后外部客户端调用的时候，
 * 创建这个新增的报价策略实现，并设置到策略上下文就可以了，对原来已经实现的代码没有任何的改动。
 */
public class Client {
    public static void main(String[] args) {
        //1.创建老客户的报价策略
        IQuoteStrategy oldQuoteStrategy = new OldCustomerQuoteStrategy();

        //2.创建报价上下文对象，并设置具体的报价策略
        QuoteContext quoteContext = new QuoteContext(oldQuoteStrategy);

        //3.调用报价上下文的方法
        BigDecimal price = quoteContext.getPrice(new BigDecimal(100));
        System.out.println("折扣价为：" + price);
        //1.创建MVP客户的报价策略
        IQuoteStrategy mvpQuoteStrategy = new MVPCustomerQuoteStrategy();
        //2.设置具体的报价策略
        quoteContext.setQuoteStrategy(mvpQuoteStrategy);
        //3.调用报价上下文的方法
        BigDecimal price1 = quoteContext.getPrice(new BigDecimal(100));

        System.out.println("折扣价为：" + price1);
    }
}
