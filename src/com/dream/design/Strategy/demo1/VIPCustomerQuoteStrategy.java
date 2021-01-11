package com.dream.design.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:55
 * @Description:
 */
public class VIPCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("恭喜！VIP客户享有8折优惠！");
        originalPrice = originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }
}
