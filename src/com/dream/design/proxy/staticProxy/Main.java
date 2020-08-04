package com.dream.design.proxy.staticProxy;

/**
 * @author jiangll01
 * @Date: 2020/7/29 8:55
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        // 想要发达的Java3y
        Java3y java3y = new Java3y();

        // 受委托程序员大V
        Programmer programmer = new ProgrammerBigV(java3y);

        // 受委托程序员大V让Java3y发文章，大V(自己)来点赞
        programmer.coding();
    }
}
