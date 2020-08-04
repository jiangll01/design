package com.dream.design.singleton;

/**
 * @author jiangll01
 * @Date: 2020/7/6 15:23
 * @Description: 通过静态内部类来实现创建单例模式,可以保证线程安全性？
 */
public class InnerSingleton {
    private static class SingletonHolder{
        private static final InnerSingleton innerSingleton = new InnerSingleton();
    }

    private InnerSingleton(){}
    public static  final InnerSingleton getInstance(){
        return SingletonHolder.innerSingleton;
    }
}
