package com.dream.design.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:56
 * @Description:
 */

public class QuoteContext {
    //持有一个具体的报价策略
    private IQuoteStrategy quoteStrategy;

    //注入报价策略
    public QuoteContext(IQuoteStrategy quoteStrategy) {
        this.quoteStrategy = quoteStrategy;
    }

    //回调具体报价策略的方法
    public BigDecimal getPrice(BigDecimal originalPrice) {
        return quoteStrategy.getPrice(originalPrice);
    }

    public IQuoteStrategy getQuoteStrategy() {
        return quoteStrategy;
    }

    public void setQuoteStrategy(IQuoteStrategy quoteStrategy) {
        this.quoteStrategy = quoteStrategy;
    }
}
