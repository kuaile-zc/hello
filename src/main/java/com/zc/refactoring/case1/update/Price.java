package com.zc.refactoring.case1.update;

/**
 * 用于联系 Movie 和 不同类型的电影
 * @author CoreyChen Zhang
 * @version 2021/3/26 0:18
 * @modified
 */
public abstract class Price {

    public abstract double getPrice(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
