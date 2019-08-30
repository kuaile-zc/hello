package com.zc.Lambdas.stream.practice;

/**
 *
 * @author zc
 * @create 2019-03-18 20:29
 */
public class Transction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
