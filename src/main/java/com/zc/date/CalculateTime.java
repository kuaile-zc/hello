package com.zc.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 计算时间
 * @author CoreyChen Zhang
 * @version 2021/4/7 16:09
 * @modified
 */
public class CalculateTime {

    public static void main(String[] args) {
        //当前时间
        LocalDate localDate = LocalDate.now();
        Period.of(0,0,1);
        System.out.println("当前时间:"+ localDate);
        LocalDate localDate2 = localDate.plus(Period.of(0, 0, 7));
        LocalDate localDate1 = localDate.plusWeeks(1);
        System.out.println("当前时间一周后:"+ localDate1);
        System.out.println("当前时间一周后:"+ localDate2);
        System.out.println(localDate.getDayOfWeek().getValue());

        //使用 ChronoUnit来计算时间
        //案例使用计算 2020.2.2.11.11.11 十年后 和十年后的半天后
        LocalDateTime standTime = LocalDateTime.of(2020, Month.FEBRUARY, 2, 11, 11, 11);
        LocalDateTime tenYearLater = standTime.plus(1, ChronoUnit.DECADES);
        System.out.println("Ten year is :"+ tenYearLater);
        LocalDateTime inviteFriend = tenYearLater.plus(1, ChronoUnit.HALF_DAYS);
        System.out.println("Invite friend time :"+ inviteFriend);
    }
}
