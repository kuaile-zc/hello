package com.zc.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 返回日期
 * 加入一个员工一个月15号发薪水，如果15号是周末那么周五发
 * @Author CoreyChen Zhang
 * @Date: 2021/04/07/ 20:27
 */
public class PayDayAdjuster implements TemporalAdjuster {


    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate localDate = LocalDate.from(temporal);
        //判断是不是15号
        int day = 15;
        LocalDate realPayDay = localDate.withDayOfMonth(day);
        if (realPayDay.getDayOfWeek() == DayOfWeek.SUNDAY || realPayDay.getDayOfWeek() == DayOfWeek.SATURDAY)
            return realPayDay.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        return realPayDay;
    }

    public static void main(String[] args) {
        //封装对象2018 12 1
        LocalDate localDate = LocalDate.of(2018, 12, 1);
        LocalDate realPayDay = LocalDate.from(new PayDayAdjuster().adjustInto(localDate));
        System.out.println("真实发薪日:"+ realPayDay);

    }
}
