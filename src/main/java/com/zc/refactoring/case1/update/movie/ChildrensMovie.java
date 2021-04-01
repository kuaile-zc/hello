package com.zc.refactoring.case1.update.movie;

import com.zc.refactoring.case1.update.Movie;
import com.zc.refactoring.case1.update.Price;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/26 0:31
 * @modified
 */
public class ChildrensMovie extends Price {
    @Override
    public double getPrice(int daysRented) {
        double ret = 1.5;
        if (daysRented > 3)
            ret += (daysRented - 3) * 1.5;
        return ret;
    }
}
