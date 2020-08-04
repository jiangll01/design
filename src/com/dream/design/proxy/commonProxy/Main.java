package com.dream.design.proxy.commonProxy;

import com.dream.design.proxy.staticProxy.Programmer;
import com.dream.design.proxy.staticProxy.ProgrammerBigV;

/**
 * @author jiangll01
 * @Date: 2020/7/29 9:01
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        // 受委托程序员大V
        Programmer programmer = new commonProxy();

        // 受委托程序员大V让Java3y发文章，大V来点赞
        programmer.coding();

    }
}
