package com.zc;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-01-12 13:22
 */
public class DoubleTest {


    public static void main(String[] args) {
        double a= 0.2;
        double a1= 0.4;
        double b = 0.5+0.1;
        System.out.println(a);
        System.out.println(b);

        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        String clusterName = "csmtest-1992236456";
        final int beginIndex = clusterName.lastIndexOf("-") + 1;
        String clusterId = clusterName.substring(beginIndex >= clusterName.length() ? 0 : beginIndex);
        System.out.println(clusterId);

    }

}
