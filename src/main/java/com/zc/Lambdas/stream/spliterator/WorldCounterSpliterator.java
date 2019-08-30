package com.zc.Lambdas.stream.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-04-21 10:24
 */
public class WorldCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currenChar = 0;


    public WorldCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currenChar++));
        return currenChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currenChar;
        if (currentSize <10){
            return null;
        }
        for (int splitPos =currentSize/2 +currenChar;splitPos<string.length();splitPos++){
            if (Character.isWhitespace(string.charAt(splitPos))){
                Spliterator spliterator = new WorldCounterSpliterator(string.substring(currenChar,splitPos));
                currenChar = splitPos;
                return spliterator;
            }
        }


        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currenChar;
    }

    @Override
    public int characteristics() {
        return ORDERED+SIZED+SUBSIZED+NONNULL+IMMUTABLE;
    }
}
