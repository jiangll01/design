package com.dream.design.builder;

/**
 * @author jiangll01
 * @Date: 2021/1/11 11:24
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        User d = User.builder()
                .name("foo")
                .password("pAss12345")
                .age(25)
                .build();
    }
}
