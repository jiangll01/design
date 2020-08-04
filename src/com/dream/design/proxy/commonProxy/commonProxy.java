package com.dream.design.proxy.commonProxy;

import com.dream.design.proxy.staticProxy.Java3y;
import com.dream.design.proxy.staticProxy.Programmer;

/**
 * @author jiangll01
 * @Date: 2020/7/29 8:59
 * @Description:
 */
public class commonProxy implements Programmer {
    // 指定程序员大V要给Java3y点赞
    private Java3y java3y ;

    // 只做Java3y的生意了
    public commonProxy() {
        this.java3y = new Java3y();
    }

    // 程序员大V点赞评论收藏转发
    public void upvote() {
        System.out.println("程序员大V点赞评论收藏转发！");
    }

    @Override
    public void coding() {
        // 让Java3y发文章了
        java3y.coding();

        // 程序员大V点赞评论收藏转发！
        upvote();
    }
}
