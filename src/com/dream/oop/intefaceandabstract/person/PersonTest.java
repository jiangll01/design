package com.dream.oop.intefaceandabstract.person;

import org.junit.Test;

/**
 * @author jiangll01
 * @Date: 2020/7/31 17:39
 * @Description:
 */
public class PersonTest {
    @Test
    public void test() {
        person person = new Student();
        person.think();
        Teacher teacher = new Teacher();
        teacher.think();
    }
}
