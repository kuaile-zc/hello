package com.zc;

import com.zc.sample.jackson.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author zc
 * @create 2019-03-04 20:16
 */
public class Hello {
    public static void main(String[] args) {
//        System.out.println("Hello1");
//        List list1 = new ArrayList<Car>();
//        list1.add(new Car("BenChi",new BigDecimal(1),3.1d));
//        System.out.println(list1.getClass());
//        System.out.println(ArrayList.class);
//        System.out.println(list1.getClass().equals(ArrayList.class));
//        System.out.println(List.class);

        int a = 12535;
        Integer i = 12535;
        System.out.println(a==i);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(123456));
        int b = 123456;
        Integer c = 123456;
        System.out.println(set.contains(b));
        System.out.println(set.contains(c));

    }
}


