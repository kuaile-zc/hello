package com.zc.Lambdas.stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author zc
 * @create 2019-03-18 20:36
 */
public class TraderPractice {

    public static void main(String[] args) {
        get_2011_Trader();
    }

    /**
     * Sorted transction's value from small to large in the 2011 year.
     *
     */
    private static void get_2011_Trader(){
        List<Transction> transctionList = TraderUtil.getTransaction().stream()
                .filter(x->x.getYear()==2011)
                .sorted(Comparator.comparing(Transction::getValue) )
                .collect(Collectors.toList());

        System.out.println(transctionList);
    }
}
