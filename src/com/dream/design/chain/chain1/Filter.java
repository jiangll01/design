package com.dream.design.chain.chain1;

/**
 * @author jiangll01
 * @Date: 2020/7/27 9:09
 * @Description:
 */
public interface Filter {
    void doFilter(String data);
}
class FilterEgg implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething 过滤鸡蛋
    }
}
class FilterAoBing implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething
    }
}

class FilterBaiCai implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething
    }
}

class FilterJiTou implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething  过滤鸡头
    }
}
