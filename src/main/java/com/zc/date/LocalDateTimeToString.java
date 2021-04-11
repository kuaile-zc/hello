package com.zc.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * LocalDateTime 和 String互相转换
 * @author CoreyChen Zhang
 * @version 2021/4/8 15:27
 * @modified
 */
public class LocalDateTimeToString {

    public static void main(String[] args) {
        //对LocalDateTime转换成String
        LocalDateTime localDateTime = LocalDateTime.now();

        String s1 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        String s2 = localDateTime.format(DateTimeFormatter.ISO_DATE);

        System.out.println("LocalDateTime: "+ localDateTime);
        System.out.println("ISO_DATE_TIME: "+ s1);
        System.out.println("ISO_DATE: "+ s2);

        String dateStr = "2014==04==12 01时06分09秒";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateStr, formatter);
        System.out.println("解析之后的日期是: "+ localDateTime1);

        System.out.println("FULL: "+ localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
//        System.out.println("FULL: "+ localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println("LONG: "+ localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println("MEDIUM: "+ localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println("SHORT: "+ localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }
}
