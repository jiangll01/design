package com.dream.design.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:55
 * @Description:
 */
public class OldCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("恭喜！老客户享有9折优惠！");
        originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }
}
