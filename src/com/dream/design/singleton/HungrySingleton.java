package com.dream.design.singleton;

/**
 * @author jiangll01
 * @Date: 2020/7/6 10:28
 * @Description: 饿汉式
 * 该模式的特点是类一旦加载就创建一个单例，
 * 保证在调用 getInstance 方法之前单例已经存在了。
 */
//饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，
// 以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
public class HungrySingleton {

    private final static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
