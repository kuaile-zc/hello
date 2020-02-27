package com.zc.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-01-07 19:39
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Double> dataMap = new HashMap<>();

        List<TimeData> list = new ArrayList<>();
        double datas[] = {1, 1.4, 3.67, 5.1, 502, 7.0, 9.0, 4.1};

        System.out.println(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String time = dateFormat.format(calendar.getTime());
        System.out.println(time);
        for (Double d:datas){
            TimeData timeData = new TimeData(dateFormat.format(calendar.getTime()), d);
//            dataMap.put(dateFormat.format(calendar.getTime()), d);
            list.add(timeData);
            calendar.add(Calendar.MINUTE,15);
        }

        for (TimeData timeData:list){
            System.out.println(timeData);
        }
    }
}
