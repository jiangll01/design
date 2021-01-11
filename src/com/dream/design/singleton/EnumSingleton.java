package com.dream.design.singleton;

/**
 * @author jiangll01
 * @Date: 2020/7/6 15:30
 * @Description: 通过创建枚举进行创建单例，
 * 它不仅能避免多线程同步问题，
 * 而且还能防止反序列化重新创建新的对象，
 * 可谓是很坚强的壁垒啊
 */
public enum EnumSingleton {
    //实例
    INSTANCE;

    public void whateverMethod() {
    }

}
