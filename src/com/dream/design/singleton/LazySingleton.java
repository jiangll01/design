package com.dream.design.singleton;

/**
 * @author jiangll01
 * @Date: 2020/7/6 9:31
 * @Description: 单例模式 ：懒汉式 饿汉式
 */
//单例模式的应用场景
//前面分析了单例模式的结构与特点，以下是它通常适用的场景的特点。
//在应用场景中，某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
//当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
//当某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。
public class LazySingleton {
    // 懒汉式   volatile保证 instance 在所有线程中同步,它禁止了指令重排
    private static volatile LazySingleton instance = null;

    //private 避免类在外部被实例化
    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    //双重检验，可以提高效率,如果加锁在方法上的话，并发情况下，有一个线程进去判断的话，其他线程只能阻塞等待，
    //通过双端检验这种方式呢，只有在创建的时候才会进行加锁，提高效率，内部的判断，避免线程进入
    //时，实例已经被创建了，避免创建多个实例
    public static LazySingleton getCheckInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
