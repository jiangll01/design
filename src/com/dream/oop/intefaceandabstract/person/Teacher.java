package com.dream.oop.intefaceandabstract.person;

/**
 * @author jiangll01
 * @Date: 2020/7/31 17:42
 * @Description:
 */
public class Teacher extends AbstractPerson {
    @Override
    public void think() {
        System.out.println("考虑如何教学生");
    }

    public int test(int n){
        if(n==1){
            return 1;
        }else {
             return test(n-1)+test(n-2);
        }
    }

    public static void main(String[] args) {

    }
}
