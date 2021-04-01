package com.zc.refactoring.case1.update.movie;

import com.zc.refactoring.case1.update.Movie;
import com.zc.refactoring.case1.update.Price;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/26 0:29
 * @modified
 */
public class RegularMovie extends Price {
    @Override
    public double getPrice(int daysRented) {
        double ret = 2;
        if (daysRented > 2)
            ret += (daysRented - 2) * 1.5;
        return ret;
    }
}
