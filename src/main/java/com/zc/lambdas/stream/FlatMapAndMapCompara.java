package com.zc.lambdas.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zc
 * @create 2019-03-17 12:15
 */
public class FlatMapAndMapCompara {


    /**
     * Use (1,2,3) and (3,4)
     * Joint to the
     * {a.1,b.1},{a.1,b,2}
     * Example
     *
     * {1,3},{1,4}
     * {2,3},{2,4}
     * {3,3},{3,4}
     */
    public static void Demo(){
        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);
        List<int[]> pairs= number1.stream()
                .flatMap(i -> number2.stream().map(j -> new int[]{i,j}))
                .collect(Collectors.toList());
        pairs.stream().forEach(x->
        {
            System.out.print("{");
            final int[] num = {1};
            Arrays.stream(x)
                    .forEach(y->
                        {
                            System.out.print(y) ;
                            if (num[0] ==1){
                                System.out.print(",");
                                num[0] -=1;
                            }
                        }
            );
            System.out.println("}");
        } );


    }
}
