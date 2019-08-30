package com.zc.Lambdas.stream;

import java.util.List;

/**
 *
 * @author zc
 * @create 2019-03-17 15:55
 */
public class ReduceDemo {

    public static void mapAndReduce(){
        List<Dish> menu = MenuUtil.getMenu();
        int sum = menu.stream().map(d->1)
                .reduce(0,Integer::sum);
//                .reduce(0,(a,b)->a+b);

        System.out.println(sum);
    }
}
