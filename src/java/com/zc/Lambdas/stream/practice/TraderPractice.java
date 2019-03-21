package com.zc.Lambdas.stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author zc
 * @create 2019-03-18 20:36
 */
public class TraderPractice {

    private static final List<Transction> allTransctionList = TraderUtil.getTransaction();

    public static void main(String[] args) {
        get_2011_Trader();
        get_all_city();
        get_cambridge_sort_name();
        get_all_name();
        get_max_value();
        get_min_transction();
    }

    /**
     * Sorted transction's value from small to large in the 2011 year.
     *
     */
    private static void get_2011_Trader(){
        List<Transction> transctionList = allTransctionList.stream()
                .filter(x->x.getYear()==2011)
                .sorted(Comparator.comparing(Transction::getValue) )
                .collect(Collectors.toList());

        System.out.println(transctionList);
    }


    /**
     * Find all city value .
     */
    private static void get_all_city(){
        List<String> all_city = allTransctionList.stream()
                .map(Transction::getTrader).map(Trader::getCity)
                .distinct().collect(Collectors.toList());
        System.out.println(all_city);

    }

    /**
     * Find trader city is Cambridge list, sorted by name.
     */
    private static void get_cambridge_sort_name(){
        List<Trader> tradersList  = allTransctionList.stream()
                .map(Transction::getTrader)
                .filter(x->x.getCity()=="Cambridge").distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(tradersList);
    }

    /**
     * Find all trader's name.
     */
    private static void get_all_name(){
        List<String> nameList = allTransctionList.stream()
                .map(Transction::getTrader).map(Trader::getName)
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    /**
     * Mix value
     */
    private static void get_max_value(){
        Optional<Integer> maxValue = allTransctionList.stream().map(Transction::getValue)
                .reduce(Integer::max);
        System.out.println(maxValue.get());
    }

    /**
     * Min transction
     */
    private static void get_min_transction(){
        Optional<Transction> minTransction  = allTransctionList.stream().min(Comparator.comparing(Transction::getValue));
        System.out.println(minTransction.get());

    }


}
