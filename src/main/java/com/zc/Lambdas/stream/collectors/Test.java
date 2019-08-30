package com.zc.Lambdas.stream.collectors;

import com.zc.Lambdas.stream.Dish;
import com.zc.Lambdas.stream.MenuUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zc
 * @create 2019-04-14 16:37
 */
public class Test {
    public static void main(String[] args) {
        List<Dish> menu  =  MenuUtil.getMenu();
        menu.stream().collect(new ToListCollector<Dish>());
        menu.stream().collect(Collectors.toList());

    }
}
