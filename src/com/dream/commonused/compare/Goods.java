package com.dream.commonused.compare;

/**
 * @author jiangll01
 * @Date: 2020/8/18 14:43
 * @Description: 商品类
 */

public class Goods implements Comparable {
    private String goodsName;
    private double goodsPrice;

    public Goods(String goodsName, double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    /* @Override
     //  1 ：表示从小到大 -1：从大到小 0：相等
     //安装价格从小到大
     public int compareTo(Object o) {
         return Double.compare(this.goodsPrice,((Goods) o).goodsPrice);//默认从小到大
     }*/
    @Override
    public int compareTo(Object o) {
        //让价格从大到小，相等价格按照名字从小到大
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.goodsPrice > ((Goods) o).goodsPrice) {
                return -1;
            } else if (this.goodsPrice == ((Goods) o).goodsPrice) {//价格相等时，商品名字从小到大
                return this.goodsName.compareTo(((Goods) o).goodsName);//使用默认排序，从小到大
            } else {
                return 1;
            }
        }
        throw new RuntimeException("参数类型错误");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                '}';
    }


}
