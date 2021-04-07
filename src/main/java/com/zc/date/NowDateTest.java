package com.zc.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 将所有新时间日期now打印出来
 * @author CoreyChen Zhang
 * @version 2021/4/7 14:31
 * @modified
 */
public class NowDateTest {

    public static void main(String[] args) {
        //基础类
        Instant instantNow = Instant.now();

        LocalDate localDateNow = LocalDate.now();

        LocalTime localTimeNow = LocalTime.now();

        LocalDateTime localDateTimeNow = LocalDateTime.now();

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();

        System.out.println("Instant: "+instantNow);
        System.out.println("localDateNow: "+localDateNow);
        System.out.println("localTimeNow: "+localTimeNow);
        System.out.println("localDateTimeNow: "+localDateTimeNow);
        System.out.println("zonedDateTimeNow: "+zonedDateTimeNow);


        //年月日
        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        System.out.println("year: "+year);
        System.out.println("yearMonth: "+yearMonth);
        System.out.println("monthDay: "+monthDay);

        //基础类定义指定的日期
        LocalDate localDate = LocalDate.of(2020, 5, 10);
        System.out.println("localDate: "+localDate);

    }
}
