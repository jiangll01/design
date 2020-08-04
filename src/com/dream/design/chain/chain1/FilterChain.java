package com.dream.design.chain.chain1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangll01
 * @Date: 2020/7/27 9:13
 * @Description: 过滤串串
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain(){
        filters.add(new FilterEgg());
        filters.add(new FilterAoBing());
        filters.add(new FilterBaiCai());
        filters.add(new FilterJiTou());
    }
    //对外暴露接口
    public void processData(String data) {
        for (Filter filter : filters) {
            filter.doFilter(data);
        }
    }

}
