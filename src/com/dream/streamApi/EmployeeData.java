package com.dream.streamApi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangll01
 * @Date: 2020/7/30 15:00
 * @Description:
 */
public class EmployeeData {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云", 12, 9821.1));
        list.add(new Employee(1003, "刘强东", 33, 3212.38));
        list.add(new Employee(1004, "雷军", 15, 6082.38));
        list.add(new Employee(1005, "李彦宏", 23, 6721.38));
        list.add(new Employee(1006, "比尔盖茨", 56, 7231.38));
        list.add(new Employee(1006, "任正非", 13, 3261.38));
        list.add(new Employee(1006, "扎克伯格", 77, 6100.38));
        list.add(new Employee(1006, "扎克伯格", 77, 6100.38));
        return list;
    }


}
