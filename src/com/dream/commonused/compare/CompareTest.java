package com.dream.commonused.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jiangll01
 * @Date: 2020/8/18 14:35
 * @Description: 比较器
 * 使用场景：在java中对象进行比较大小时，需要实现Comparable(自然排序)、Comaprator(定制排序)
 * Comparable(自然排序) 从小到大排序
 * 重写 compareTo（obj o）的规则：
 * 1、如果当前对象this大于形参对象obj,则返回正整数 正整数从小到大排序
 * 2、如果当前对象this小于形参对象obj，则返回负整数 负数从大到小排序
 * 3、如果当前对象等于形参对象obj,则返回零
 * <p>
 * Comaprator(定制排序) 像String等实现了Comparable自然排序，但是我们想要从大到小排序就需要定制排序
 * compare(Object 01,Object 01) 比较o1、o2的大小。
 * 如果返回正整数则表示o1大于o2,返回0表示相等，返回复数o1小于o2
 */
public class CompareTest {
    @Test
    public void test() {
       /*
       Comparable(自然排序) 从小到大排序 像String、包装类都重写了此方法
       */
        String[] str = {"gg", "aa", "kk", "ss", "ww", "cc"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        //比较大小
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("lenovoMouse", 64));
        list.add(new Goods("dellMouse", 99));
        list.add(new Goods("aiaomiMouse", 44));
        list.add(new Goods("huaweiMouse", 44));
        list.add(new Goods("pingguoMouse", 106));
        Collections.sort(list);//对象必须实现Comparable接口
        System.out.println(list);
    }

    @Test
    public void test1() {
        /**
         * 自然排序满足不了，又或者是因为我们对String等按照自定义的规则、
         * 对象不想实现 Comparable 就可以使用自定义规则
         */
        //通过自定义实现字符串从大到小
        String[] str = {"gg", "aa", "kk", "ss", "ww", "cc"};
        Arrays.sort(str, (o1, o2) -> {
            return -o1.compareTo(o2);
        });
        System.out.println(Arrays.toString(str));
        //比较大小
        List<Person> list = new ArrayList<>();
        list.add(new Person("lenovoMouse", 64));
        list.add(new Person("dellMouse", 99));
        list.add(new Person("aiaomiMouse", 44));
        list.add(new Person("huaweiMouse", 44));
        list.add(new Person("pingguoMouse", 106));
        Collections.sort(list, (o1, o2) -> {
            return -Integer.compare(o1.getAge(), o2.getAge());//按照年龄从大到小排序
        });//对象必须实现Comparable接口
        System.out.println(list);
        //按照年龄从小到大，当年龄相等时，按照命名从大到小排序
        Collections.sort(list, (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) {
                return 1;
            } else if (o1.getAge() < o2.getAge()) {
                return -1;
            } else {
                return -o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(list);
    }
}
