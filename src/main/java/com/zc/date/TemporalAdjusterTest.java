package com.zc.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 使用模板方法获取各种特殊日期
 * @author CoreyChen Zhang
 * @version 2021/4/7 18:00
 * @modified
 */
public class TemporalAdjusterTest {

    public static void main(String[] args) {
        //获取当前时间
        LocalDate now = LocalDate.now();
        System.out.println("当前时间为:"+ now);
        //修改时间为当前月的第一天
        System.out.println("当前月的第一天: "+now.with(TemporalAdjusters.firstDayOfMonth()));
        //修改时间为下个月的第一天
        System.out.println("下个月的第一天: "+now.with(TemporalAdjusters.firstDayOfNextMonth()));
        //修改时间为下一年的第一天
        System.out.println("下一年的第一天: "+now.with(TemporalAdjusters.firstDayOfNextYear()));
        //修改时间为本年的第一天
        System.out.println("本年的第一天: "+now.with(TemporalAdjusters.firstDayOfYear()));
        //修改时间为本月的最后一天
        System.out.println("本月的最后一天: "+now.with(TemporalAdjusters.lastDayOfMonth()));
        //修改时间为本年的最后一天
        System.out.println("本年的最后一天: "+now.with(TemporalAdjusters.lastDayOfYear()));


        //上一个周一
        System.out.println("上一个周一: "+now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        //上一个周日
        System.out.println("上一个周一: "+now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));
        //下一个周三
        System.out.println("下一个周三: "+now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));

    }
}
