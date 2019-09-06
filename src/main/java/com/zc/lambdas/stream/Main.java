package com.zc.lambdas.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zc
 * @create 2019-03-14 21:00
 */
public class Main {
    public static void main(String[] args) {
        FlatMapAndMapCompara.Demo();
        ReduceDemo.mapAndReduce();
        List<Dish> lists = MenuUtil.getMenu();
        String name = lists.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(name);
    }



}
