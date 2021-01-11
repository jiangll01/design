package com.dream.commonused.jdk8datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * @author jiangll01
 * @Date: 2020/8/19 9:40
 * @Description: spring的项目通过注解实现前后端时间的格式化、解析
 * @DatetimeFormat是将String转换成Date，一般前台给后台传值时用
 * @JsonFormat(pattern="yyyy-MM-dd") 将Date转换成String 一般后台传值给前台时
 * @JsonFormat会让时间以0区时间显示。如果直接使用会少了8小时（我所在的是北京时区）修改为
 * @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
 * @JsonFormat(pattern="yyyy-MM-dd") //从数据库读出日期格式时，进行转换的规则
 * @DateTimeFormat(pattern = "yyyy-MM-dd")//接受从前端传入的日期格式，映射到java类日期属性的规则
 * <p>
 * jdk8中的时间api  LocalDate、LocalTime、LocalDateTime
 */
public class DateTimeTest {
    @Test
    public void test() {
        //util包下的时间格式,jdk8之前的时间
        Date date = new Date();
        System.out.println(date);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        //日期
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //时间
        LocalTime time = LocalTime.now();
        System.out.println(time);
        //日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //设置指定年月日时分秒
        LocalDateTime of = LocalDateTime.of(2020, 10, 2, 12, 0, 50);
        System.out.println(of);
        //getXXX（）这个月的第几天，这周的第几天，这一年的第几天
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        //withXXX()设置
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(20);
        System.out.println(localDateTime1);
        System.out.println("********************************");
        //plusXXX()增加 minusXXX()减少
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        LocalDateTime localDateTime2 = now1.plusDays(2);//增加两天
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = now1.minusHours(1);
        System.out.println(localDateTime3);//减一个小时
        LocalDateTime localDateTime4 = now1.minusMonths(1);
        System.out.println(localDateTime4);//减一个月
    }

    @Test
    /**
     * Instant 瞬时点
     * 类似java.util.Date类
     */
    public void test1() {
        //获取零时区的时间点
        Instant now = Instant.now();
        System.out.println(now);
        //把零时区的时间修改为东八区
        OffsetDateTime dateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(dateTime);
        //获取距离1970年的毫秒数
        long second = now.toEpochMilli();
        System.out.println(second);
        //将毫秒数转为零时区
        Instant instant = Instant.ofEpochMilli(1597806037911L);
        System.out.println(instant);

    }

    /**
     * DateTimeFormatter 进行格式化和解析
     * 格式化是将日期转为字符串
     * 解析是将字符串转为日期
     */
    @Test
    public void test2() {
        //格式化：将日期转为字符串
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(now);
        System.out.println(format);
        //解析：将字符串转为日期
        TemporalAccessor parse = formatter.parse("2020-08-19 11:11:38");
        System.out.println(parse);

    }

    /**
     * 时区类
     */
    @Test
    public void tets3() {
        //获取所有的ZoneIds
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.stream().forEach(System.out::println);
        //获取指定时区的时间
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));//获取中国时间
        System.out.println(now);
        //带时区的日期时间
        ZonedDateTime now1 = ZonedDateTime.now();//获取本地时区时间
        System.out.println(now1);
        ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));//获取指定时区时间
        System.out.println(now2);

    }

    /**
     * 计算两个时间间隔，以秒、纳秒为基准
     */
    @Test
    public void test4() {
        //计算两个时间之间的差值
        LocalTime now = LocalTime.now();
        LocalTime of = LocalTime.of(15, 23, 32);
        Duration between = Duration.between(of, now);
        System.out.println(between);
        System.out.println(between.getNano());
        System.out.println(between.getSeconds());
        System.out.println(between.getUnits());

        LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 19, 11, 34);
        LocalDateTime localDateTime1 = LocalDateTime.of(1992, 1, 18, 11, 34);
        Duration between1 = Duration.between(localDateTime1, localDateTime);
        System.out.println(between1.toDays());
        System.out.println(between1.toHours());
        System.out.println(between1.toMinutes());
    }

    /**
     * 时间校正器
     */
    @Test
    public void test5() {
        //获取当前日期的下一个周日是那些？
        TemporalAdjuster next = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime with = LocalDateTime.now().with(next);
        System.out.println(with);
        //获取下一个工作日是哪天？

    }

}


