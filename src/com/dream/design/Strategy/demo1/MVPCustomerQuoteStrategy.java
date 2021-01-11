package com.dream.design.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 15:01
 * @Description:
 */
public class MVPCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("哇偶！MVP客户享受7折优惠！！！");
        originalPrice = originalPrice.multiply(new BigDecimal(0.7)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }
}
