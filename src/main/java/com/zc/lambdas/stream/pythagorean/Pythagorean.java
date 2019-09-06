package com.zc.lambdas.stream.pythagorean;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author zc
 * @create 2019-03-24 21:45
 */
public class Pythagorean {

    public static void main(String[] args) {
        Stream<int[]> pythgoreanTriples =
                IntStream.range(1,100).boxed()
                .flatMap(a->
                    IntStream.range(a,100)
                            .filter(b->Math.sqrt(a*a+b*b)%1==0)
                            .mapToObj(b->new int[]{a,b,(int) Math.sqrt(a*a+b*b)})
                );

        pythgoreanTriples.forEach(
                x-> System.out.println(x[0]+" "+x[1] +" "+x[2])
        );

        Stream<double[]> pythgoreanTriples2 =
                IntStream.range(1,100).boxed()
                .flatMap(a->IntStream.rangeClosed(a,100)
                        .mapToObj(b->new double[]{a,b,Math.sqrt(a*a+b*b)}).filter(t->t[2]%1==0)
                );


    }
}
