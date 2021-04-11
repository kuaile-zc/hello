package com.zc.refactoring.case1.update.movie;

import com.zc.refactoring.case1.update.Movie;
import com.zc.refactoring.case1.update.Price;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/26 0:31
 * @modified
 */
public class NewReleaseMovie extends Price {
    @Override
    public double getPrice(int daysRented) {
        double ret = daysRented * 3;
        return ret;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
