package com.zc.refactoring.case1.old;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/25 23:29
 * @modified
 */
public class Rental {

    private Movie _movie; // 影片
    private int _daysRented; // 租期

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
}
