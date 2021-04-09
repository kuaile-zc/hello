package com.zc.date;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 将Date 类转换成 LocalDate类
 * @author CoreyChen Zhang
 * @version 2021/4/8 14:47
 * @modified
 */
public class DateToLocalDateTest {

    public static void main(String[] args) {
        //初始化Date  util.Date
        Date date = new Date();
        //获取Instant
        Instant instant = date.toInstant();
        //设置默认时区
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        //转换成LocalDateTime
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        System.out.println("旧时间为:"+ date);
        System.out.println("新时间为:"+ localDateTime);

        //初始化Date  sql.Date
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        LocalDate localDate = sqlDate.toLocalDate();
        System.out.println("旧时间为:"+ sqlDate);
        System.out.println("新时间为:"+ localDate);

        //初始化 java.sql.Timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime1 = timestamp.toLocalDateTime();
        System.out.println("旧时间为:"+ timestamp);
        System.out.println("新时间为:"+ localDateTime1);

        //Calendar转换 1.初始化 由于Calendar自己带时区所以要先找出时区
        Calendar calendar = Calendar.getInstance();
        Instant instant1 = calendar.toInstant();
        //2.获取时区
        TimeZone timeZone = calendar.getTimeZone();
        ZoneId zoneId = timeZone.toZoneId();
        //3.转换
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant1, zoneId);
        System.out.println("旧时间为:"+ calendar);
        System.out.println("新时间为:"+ zonedDateTime1);

    }
}
