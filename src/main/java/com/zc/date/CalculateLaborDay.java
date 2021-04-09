package com.zc.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * 计算下一个劳动节要多少天
 * @author CoreyChen Zhang
 * @version 2021/4/8 10:09
 * @modified
 */
public class CalculateLaborDay implements TemporalQuery<Long> {
    @Override
    public Long queryFrom(TemporalAccessor temporal) {
        //1.获取传入时间
        LocalDate localDate = LocalDate.from(temporal);
        int year = localDate.getYear();
        //2.根据传入时间得到当年的劳动节日期
        LocalDate laborDay = LocalDate.of(year, Month.MAY, 1);
        //3.判断时间是否在劳动节日期之前
        if (localDate.isAfter(laborDay)){
            //4.如果已经是之后那么加一年
            laborDay = laborDay.plusYears(1);
        }

        return ChronoUnit.DAYS.between(localDate, laborDay);
    }

    static public CalculateLaborDay instanceCalculateLaborDay(){
        return new CalculateLaborDay();
    }

    public static void main(String[] args) {
        //2020.5.2
        LocalDate localDate = LocalDate.of(2020, Month.MAY, 2);
        Long subDay = localDate.query(CalculateLaborDay.instanceCalculateLaborDay());
        System.out.println("2020.5.2下一个劳动节还有天数:"+subDay);
    }
}
