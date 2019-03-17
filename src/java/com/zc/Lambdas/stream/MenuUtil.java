package com.zc.Lambdas.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *
 * @author zc
 * @create 2019-03-17 12:10
 */
public class  MenuUtil {
    public static List<Dish> getMenu(){
        List<Dish> menu = new ArrayList<>(Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        ));
        return menu;
    }
}
