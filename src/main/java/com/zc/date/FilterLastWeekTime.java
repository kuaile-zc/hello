package com.zc.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * 筛选出属于上周的时间
 * @author CoreyChen Zhang
 * @version 2021/4/8 16:44
 * @modified
 */
public class FilterLastWeekTime {

    public static void main(String[] args) {
        isLastWeek(LocalDateTime.of(2021, Month.APRIL, 4, 10, 24,21));
    }

    private static boolean isLastWeek(LocalDateTime localDateTime){
        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalDate lastWeekFirstDay = now.minusWeeks(1).minusDays(dayOfWeek.ordinal());
        LocalDate lastWeekLastDay = lastWeekFirstDay.plusDays(6);

        LocalDate localDate = localDateTime.toLocalDate();
        boolean after  = localDate.compareTo(lastWeekFirstDay) >= 0;
        boolean before = lastWeekLastDay.compareTo(localDate) >= 0;

        return after && before;
    }
}
