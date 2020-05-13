package com.zc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-24 0:13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> responseMap = new HashMap<String,Integer>();
        HashMap<String,Integer> des = new HashMap<String,Integer>();
        String responseStr = "";
        while (scanner.hasNext()){
            String origin = scanner.next();
            String[] splitData = origin.split("@");
            String[] keys = getKeys(splitData[0]);
            HashMap<String,Integer> full = getDataMap(splitData[0]);
            if (splitData.length == 2){
                des = getDataMap(splitData[1]);
            }

            for (Map.Entry<String, Integer> ret: full.entrySet()){
                String key = ret.getKey();
                Integer desValue = des.get(key) == null ? 0: des.get(key);
                Integer value  = ret.getValue() - desValue;
                if (value>0){
                    responseMap.put(key,value);
                }

            }

            for (String key:keys){
                if (responseMap.get(key) != null){
                    responseStr = responseStr + key + ":" + responseMap.get(key) + ",";
                }

            }

            responseStr = responseStr.substring(0,responseStr.length()-1);

        }

        System.out.println(responseStr);
    }

    private static HashMap<String,Integer> getDataMap(String origin){
        HashMap<String,Integer> ret = new HashMap<String,Integer>();
        String[] dataMap = origin.split(",");
        for (String str:dataMap){
            String[] result = str.split(":");
            ret.put(result[0],Integer.valueOf(result[1]));
        }
        return ret;
    }

    private static String[] getKeys(String origin){
        String[] ret  = new String[100];
        String[] dataMap = origin.split(",");
        for (int i = 0; i < dataMap.length; i++){
            String[] result = dataMap[i].split(":");
            ret[i] = result[0];
        }
        return ret;
    }
}
