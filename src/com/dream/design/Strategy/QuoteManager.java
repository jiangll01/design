package com.dream.design.Strategy;

import java.math.BigDecimal;

/**
 * @author jiangll01
 * @Date: 2020/11/18 14:35
 * @Description: 打折管理
 * 把不同客户的报价的算法都放在了同一个方法里面，使得该方法很是庞大
 * 1、解决办法 可以把各个方法进行抽取
 * 它把每个具体的算法都单独抽出来作为一个方法，
 * 当某一个具体的算法有了变动的时候，只需要修改响应的报价算法就可以了。
 * 1.当我们新增一个客户类型的时候，首先要添加一个该种客户类型的报价算法方法，然后再quote方法中再加一个else if的分支，
 * 是不是感觉很是麻烦呢？而且这也违反了设计原则之一的开闭原则（open-closed-principle）.
 * 2、需要通过策略模式进行修改代码，增加其拓展性，根本是通过多态来实现
 */
public class QuoteManager {
    public BigDecimal quote(BigDecimal originalPrice, String customType) {
        if ("新客户".equals(customType)) {
            return quoteNewCustomer(originalPrice);
        } else if ("老客户".equals(customType)) {
            return quoteOldCustomer(originalPrice);
        } else if ("VIP客户".equals(customType)) {
            return quoteVIPCustomer(originalPrice);
        }
        //其他人员都是原价
        return originalPrice;
    }

    /**
     * 对VIP客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteVIPCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜你！VIP客户打8折！");
        originalPrice = originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }

    /**
     * 对老客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteOldCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜！老客户打9折");
        originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }

    /**
     * 对新客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteNewCustomer(BigDecimal originalPrice) {
        System.out.println("抱歉！新客户没有折扣！");
        return originalPrice;
    }
}
