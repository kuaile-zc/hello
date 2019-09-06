package com.zc.lambdas.stream.spliterator;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-04-21 10:45
 */
public class Main {

    final static String SENTENCE = " Nel mezzo del cammin di nostra vita "+
            "mi ritroval in una selva oscura "+
            "che la dritta via era smarrita";


    public static void main(String[] args) {

        //Serial operation
        Stream<Character> stream = IntStream.range(0,SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
//        System.out.println("Found "+countWorlds(stream));


        //Parallel operation      StreamSupport second parameter was mean parallel(true)
        Spliterator<Character> spliterator = new WorldCounterSpliterator(SENTENCE);
        Stream<Character> stram  = StreamSupport.stream(spliterator,true);
        System.out.println("Found "+countWorlds(stream));
    }

    private static int countWorlds(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0,true)
                                                , WordCounter::accumulate
                                                , WordCounter::combine);
        return wordCounter.getCounter();
    }


}
