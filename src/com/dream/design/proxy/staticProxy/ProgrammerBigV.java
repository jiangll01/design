package com.dream.design.proxy.staticProxy;

/**
 * @author jiangll01
 * @Date: 2020/7/29 8:54
 * @Description:
 */
public class ProgrammerBigV implements Programmer {
    // 指定程序员大V要让谁发文章(先发文章、后点赞)
    private Java3y java3y;

    public ProgrammerBigV(Java3y java3y) {
        this.java3y = java3y;
    }

    // 程序员大V点赞评论收藏转发
    public void upvote() {
        System.out.println("程序员大V点赞评论收藏转发！");
    }

    @Override
    public void coding() {
        // 让Java3y发文章
        java3y.coding();

        // 程序员大V点赞评论收藏转发！
        upvote();
    }
}
