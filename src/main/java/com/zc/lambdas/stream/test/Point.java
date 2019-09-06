package com.zc.lambdas.stream.test;


import java.util.Comparator;

import static java.util.Comparator.comparing;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-12 16:36
 */
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x){
        return new Point(this.x+x,this.y);
    }

    public final static Comparator<Point> compareByXAndThenY =
            comparing(Point::getX).thenComparing(Point::getY);
}
