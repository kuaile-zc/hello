package com.zc.Lambdas.stream.practice;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zc
 * @create 2019-03-18 20:31
 */
public class TraderUtil {

    public static List<Transction> getTransaction(){

        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transction> transctionsList = Arrays.asList(
                new Transction(brian,2011,300),
                new Transction(raoul,2012,1000),
                new Transction(raoul,2011,400),
                new Transction(mario,2012,710),
                new Transction(mario,2012,700),
                new Transction(alan,2012,950)
        );

        return transctionsList;


    }
}
