package com.zc.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 关于时区
 * @author CoreyChen Zhang
 * @version 2021/4/7 15:16
 * @modified
 */
public class TimeZoneTest {

    public static void main(String[] args) {
        //获取所有时区 一共599个
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        //获取当前时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("This computer time zone is :"+ zoneId);

        //需求知道上海的时间 2020.10.3 8:00:32 求出东京是几点
        LocalDateTime localDateTime = LocalDateTime.of(2020, 10, 3, 8, 0, 32);
        ZonedDateTime shanghaiZonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("Shanghai time zone is: "+ shanghaiZonedDateTime);
        ZonedDateTime tokyoZonedDateTime = shanghaiZonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokyo time zone is: "+ tokyoZonedDateTime.toString());
    }
}
