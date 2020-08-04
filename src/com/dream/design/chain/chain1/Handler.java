package com.dream.design.chain.chain1;

/**
 * @author jiangll01
 * @Date: 2020/7/27 9:17
 * @Description:  处理
 */
public class Handler {
    public void handlerRequest(Request request) {
        // 得到请求的数据
        String data = request.getData();
        FilterChain filterChain = new FilterChain();
        // 处理数据
        filterChain.processData(data);

    }
}
