package com.dream.streamApi;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;

/**
 * @author jiangll01
 * @Date: 2020/7/30 14:49
 * @Description: Stream到底是什么呢？ 使用
 * Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询
 * 是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
 * “集合讲的是数据， Stream讲的是计算！”
 * 注意：
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 */
public class StreamApiTest {
    /**
     * Stream 的操作三个步骤
     *  1- 创建 Stream
     * 一个数据源（如：集合、数组），获取一个流
     *  2- 中间操作
     * 一个中间操作链，对数据源的数据进行处理
     *  3- 终止操作(终端操作)
     * 一旦执行终止操作， 就执行中间操作链，并产生结果。之后，不会再被使用
     */
    @Test
    public void test() {
        //创建stream流的方式  1、通过集合创建
        List<Integer> list = Arrays.asList(1, 2, 4);
        //创建串行流
        Stream<Integer> stream = list.stream();
        //创建并行流
        Stream<Integer> parallelStream = list.parallelStream();

        /*通过数组*/
        IntStream intStream = Arrays.stream(new int[]{1, 2});
        Stream<Employee> employeeStream = Arrays.stream(new Employee[]{});

        /*通过Stream的of() */
        Stream<Integer> integerStream = Stream.of(12);
    }

    /** 中间操作
     * 1-筛选与切片
     * 2-映 射
     * 3-排序
     */

    /**
     * 1-筛选与切片
     */
    @Test
    public void test1() {
        /*
        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        limit(long maxSize) 截断流，使其元素不超过给定数量
        skip(long n) 跳过元素，返回一个扔掉了前 个空流。与 limit(n) 互补 n 个
        */
        // 1、filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().filter(employee -> {
            return employee.getAge() > 20;
        }).forEach(e -> System.out.println(e));
        System.out.println("***************************************");
        list.stream().filter(e -> e.getAge() < 20).forEach(System.out::println);
        System.out.println("***************************************");
        // 2、distinct() 筛选，通过流所生成元素（一定要重写类的）的 hashCode() 和 equals() 去除重复元素,
        list.stream().distinct().forEach(System.out::println);
        System.out.println("***************************************");
        //3、limit(long maxSize) 截断流，使其元素不超过给定数量
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("***************************************");
        //4、skip(long n) 跳过元素，就是跳过前面的，返回一个扔掉了前 个空流。与 limit(n) 互补 n 个
        list.stream().skip(2).forEach(System.out::println);
    }

    /**
     * 2-映 射
     */
    @Test
    public void test2() {
       /*
        map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        如mapToInt就是把原始Stream转换成一个新的Stream，这个新生成的Stream中的元素都是int类型。
        之所以会有这样三个变种方法，可以免除自动装箱/拆箱的额外消耗；
        mapToDouble(ToDoubleFunction f)  接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
        mapToInt(ToIntFunction f)   接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
        mapToLong(ToLongFunction f)  接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
        flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        */

        //1、map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        Arrays.asList(1, 2, 3).stream().map((arr) -> {
            return arr * 2;
        }).forEach(System.out::println);
        System.out.println("**************************************");
        Arrays.asList(1, 2, 3).stream().map(a -> a * 3).forEach(System.out::println);
        System.out.println("**************************************");
        EmployeeData.getEmployees().stream().map(employee -> employee.getName()).forEach(System.out::println);
        System.out.println("**************************************");
        // 2、flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        //主要应用集合嵌套集合

        List<String> list1 = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> list2 = Arrays.asList("Warner", "Watson", "Smith");
        List<List<String>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        Stream<String> stringStream = lists.stream().flatMap(Collection::stream);
        //主要应用集合嵌套集合,将期打散后汇集成一个流
        lists.stream().flatMap(Collection::stream).forEach(s -> {
            System.out.println(s + "  " + "aa");
        });

    }

    /**
     * 3-排序
     */
    @Test
    public void test3() {
        /**
         * sorted() 产生一个新流，其中按自然顺序排序
         * sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
         */
        //1、sorted() 产生一个新流，其中按自然顺序排序,从小到大
        Arrays.asList(1, 3, 6, 0, 2, 3, 78, -1, 4).stream().sorted().forEach(System.out::println);
        System.out.println("**************************************");
        Arrays.asList(1, 3, 6, 0, 2, 3, 78, -1, 4).stream().sorted(Integer::compareTo).forEach(System.out::println);
        System.out.println("**************************************");
        //实现从大到小,通过添加负号
        Arrays.asList(1, 3, 6, 0, 2, 3, 78, -1, 4).stream().sorted((x, y) -> {
            return -Integer.compare(x, y);
        }).forEach(System.out::println);
        System.out.println("**************************************");
        //通过年龄进行按照小到大排序，自然排序的话，会报错，对象未实现comparable接口
     /*   EmployeeData.getEmployees().stream()
                .sorted()
                .forEach(System.out::println);*/
        System.out.println("**************************************");
        //通过年龄进行按照小到大排序，自定义comparable接口实现
        EmployeeData.getEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out::println);
        System.out.println("**************************************");
        // /通过年龄进行按照大到小排序
        EmployeeData.getEmployees().stream().sorted((e, e1) -> {
            if (e.getAge() > e1.getAge()) {
                return -1;
            } else {
                return 1;
            }
        }).forEach(System.out::println);

        System.out.println("**************************************");
        // /通过年龄进行按照大到小排序
        EmployeeData.getEmployees().stream().sorted((e, e1) -> {
            return -Integer.compare(e.getAge(), e1.getAge());
        }).forEach(System.out::println);
    }


    /**
     * 终止操作
     * 终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例
     * 如： List、 Integer，甚至是 void 。
     *  流进行了终止操作后，不能再次使用
     */

    /**  终止操作
     * 1-匹配与查找
     * 2-归约
     * 3-收集
     */

    /**
     * 1-匹配与查找
     */
    @Test
    public void test4() {
       /*
        allMatch(Predicate p) 检查是否匹配所有元素
        anyMatch(Predicate p) 检查是否至少匹配一个元素
        noneMatch(Predicate p) 检查是否没有匹配所有元素
        findFirst() 返回第一个元素
        findAny() 返回当前流中的任意元素
        count() 返回流中元素总数
        max(Comparator c) 返回流中最大值
        min(Comparator c) 返回流中最小值
        forEach(Consumer c)
        内部迭代(使用 Collection 接口需要用户去做迭代，
        称为外部迭代。相反， Stream API 使用内部迭
        代——它帮你把迭代做了)
        */
        //是不是年龄都大于18
        System.out.println(EmployeeData.getEmployees().stream().anyMatch(e -> e.getAge() > 18));
        //只要存在一个就行
        System.out.println(EmployeeData.getEmployees().stream().allMatch(e -> e.getAge() > 18));
        //检查是否没有匹配的元素
        System.out.println(EmployeeData.getEmployees().stream().noneMatch(e -> e.getAge() > 18));
        System.out.println(EmployeeData.getEmployees().stream().findFirst());
        System.out.println("**********************************8");
        System.out.println(EmployeeData.getEmployees().stream().findAny());
        System.out.println("**********************************");
        //数据long
        System.out.println(EmployeeData.getEmployees().stream().count());
        System.out.println("**********************************");
        System.out.println(EmployeeData.getEmployees().stream().max((x, y) -> {
            return Integer.compare(x.getAge(), y.getAge());
        }));
        System.out.println(EmployeeData.getEmployees().stream().min((x, y) -> {
            return Integer.compare(x.getAge(), y.getAge());
        }));
        System.out.println("**********************************");
        EmployeeData.getEmployees().stream().forEach(employee -> {
            System.out.println(employee.getName());
        });
    }

    /**
     * 2-归约
     */
    @Test
    public void test5() {
        /**
         * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一
         * 个值。返回 T
         * reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一
         * 个值。返回 Op
         */
        //进行求和，然后加0
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //计算全部的工资
        List<Employee> list1 = EmployeeData.getEmployees();
        Optional<Double> reduce2 = list1.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(reduce2.get());
    }

    /**
     * 3-收集
     */
    @Test
    public void test6() {
        /**
         * collect(Collector c) 将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
         */
        /**
         * Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、 Set、
         * Map)。
         * 另外， Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，
         * toList List<T> 把流中元素收集到List
         * List<Employee> emps= list.stream().collect(Collectors.toList());
         * toSet Set<T> 把流中元素收集到Set
         */
        List<Integer> list = EmployeeData.getEmployees().stream().map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println(list.toString());
        List<Employee> list2 = EmployeeData.getEmployees().stream().collect(Collectors.toList());
        System.out.println(list2.toString());
    }
}
