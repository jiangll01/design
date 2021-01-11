package com.dream.design.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:54
 * @Description:
 */
public class NewCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("抱歉！新客户没有折扣！");
        return originalPrice;
    }
}
