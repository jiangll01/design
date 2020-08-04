package com.dream.design.proxy.dynamicProxy;

import com.dream.design.proxy.staticProxy.Java3y;
import com.dream.design.proxy.staticProxy.Programmer;

import java.lang.reflect.Proxy;

/**
 * @author jiangll01
 * @Date: 2020/7/29 9:04
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        // Java3y请水军
        Java3y java3y = new Java3y();
        Programmer programmerWaterArmy = (Programmer) Proxy.newProxyInstance(java3y.getClass().getClassLoader(), java3y.getClass().getInterfaces(), (proxy, method, arg) -> {

            // 如果是调用coding方法，那么水军就要点赞了
            if (method.getName().equals("coding")) {
                method.invoke(java3y, arg);
                System.out.println("我是水军，我来点赞了！");

            } else {
                // 如果不是调用coding方法，那么调用原对象的方法
                return method.invoke(java3y, arg);
            }

            return null;
        });

        // 每当Java3y写完文章，水军都会点赞
        programmerWaterArmy.coding();

    }

}
