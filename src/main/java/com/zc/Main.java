package com.zc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class Main{
    public static void main(String args[]) throws ParseException {
//        Integer[][] data = new Integer[16][16];
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()){
//            String mapHand = scanner.nextLine();
//            String[] strs = mapHand.split(" ");
//            int a = Integer.valueOf(strs[0]);
//            int b = Integer.valueOf(strs[1]);
//            for (int i=0; i < a ; i++ ){
//                String line = scanner.nextLine();
//                String[] lineValues = line.split(" ");
//                for (int j=0; j< b ; j++){
//                    data[i][j] = Integer.valueOf(lineValues[j]);
//                }
//            }
//        }
//
//        System.out.println(getIslandNumber(data));

        System.out.println("la相关");

        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(Date.from(instant));

        //设置格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date beginTime = simpleDateFormat.parse("17:00");
        Date endTime = simpleDateFormat.parse("19:00");
//        Date cur = simpleDateFormat.parse(simpleDateFormat.format(Date.from(instant)));
        Date cur = simpleDateFormat.parse("17:01");
        System.out.println(belongCalendar(cur, beginTime, endTime));

    }

    public static boolean belongCalendar(Date curDate, Date beginTime, Date endTime){
        final Calendar cur = dateChangeCalender(curDate);
        final Calendar begin = dateChangeCalender(beginTime);
        final Calendar end = dateChangeCalender(endTime);

        final boolean isAfter = cur.after(begin);
        final boolean isBefore = cur.before(end);
        return isAfter && isBefore ? true : false;
    }

    public static Calendar dateChangeCalender(Date date){
        final Calendar result = Calendar.getInstance();
        result.setTime(date);
        return result;
    }

    private static Integer getIslandNumber(Integer[][] data){
        int ret = 0;
        int m = data.length;
        if (m==0){
            return 0;
        }

        int n = data[0].length;
        for (int i = 0; i < m ; i++){
            for (int j=0 ; j < n; j++ ){
                if (data[i][j] == 1){
                    dfs(data,i,j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private static void dfs(Integer[][] data,int i, int j){
        if(i<0 || j<0 || i>=data.length || j>= data[0].length)
            return;
        if (data[i][j] == 1){
            data[i][j] = 0;
            dfs(data,i-1,j);
            dfs(data,i+1,j);
            dfs(data,i,j-1);
            dfs(data,i,j+1);
        }
    }
}


