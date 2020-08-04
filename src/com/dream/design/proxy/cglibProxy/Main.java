package com.dream.design.proxy.cglibProxy;

/**
 * @author jiangll01
 * @Date: 2020/7/29 9:37
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        UserDao instance = (UserDao) new ProxyFactory(new UserDao()).getProxyInstance();
        instance.save();
    }
}
