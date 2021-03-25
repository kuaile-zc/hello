package com.zc.refactoring.case1.update;

import com.zc.refactoring.case1.update.movie.ChildrensMovie;
import com.zc.refactoring.case1.update.movie.NewReleaseMovie;
import com.zc.refactoring.case1.update.movie.RegularMovie;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/25 23:29
 * @modified
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private Price _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    //获取单个电影租金
    public double calculateAmount(int daysRented){
        return _priceCode.getPrice(daysRented);
    }

    //计算积分
    public int calculateFrequentRenterPoints(int daysRented){
        return _priceCode.getFrequentRenterPoints(daysRented);
    }

    public String getTitle() {
        return _title;
    }

    //设置电影类型
    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case Movie.REGULAR:
                _priceCode = new RegularMovie();
                break;
            case Movie.NEW_RELEASE:
                _priceCode = new NewReleaseMovie();
                break;
            case Movie.CHILDRENS:
                _priceCode = new ChildrensMovie();
                break;
            default:
                System.out.println("No this type...");
        }
    }

}
