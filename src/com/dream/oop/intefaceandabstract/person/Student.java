package com.dream.oop.intefaceandabstract.person;

/**
 * @author jiangll01
 * @Date: 2020/7/31 16:19
 * @Description:
 */
public class Student extends AbstractPerson {
    @Override
    public void think() {
        System.out.println("学生思考学习的东西");
    }
}
