package com.zc.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;

/**
 * 练习
 * @author CoreyChen Zhang
 * @version 2021/4/7 15:36
 * @modified
 */
public class Practice {

    public static void main(String[] args) {
        //创建当前时间
        //创建当前时间只包含年月日
        //创建当前时间包含年月日时分秒和时区
        //创建2012年12月31日7时38分46秒， 月份使用枚举
        //创建2012年12月31日 月份使用枚举
        //创建7时38分46秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间"+ localDateTime);
        LocalDate localDate = LocalDate.now();
        System.out.println("前时间只包含年月日" + localDate);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("当前时间包含年月日时分秒和时区"+ zonedDateTime);
        LocalDateTime assignDateTime = LocalDateTime.of(2012, Month.DECEMBER, 31, 7, 38, 46);
        System.out.println("2012年12月31日7时38分46秒， 月份使用枚举"+ assignDateTime);
        LocalDate assignDate = LocalDate.of(2012, Month.DECEMBER, 31);
        System.out.println("2012年12月31日 月份使用枚举"+ assignDate);
        LocalTime assignTime = LocalTime.of(7, 38, 46);
        System.out.println("7时38分46秒"+assignTime);
    }
}
