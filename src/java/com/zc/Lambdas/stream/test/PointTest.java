package com.zc.Lambdas.stream.test;

import com.zc.Lambdas.stream.test.Point;
import org.junit.Test;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-12 16:43
 */
public class PointTest {

    @Test
    public void testMoveRightBy(){
        Point p1 = new Point(5,5);
        Point p2 = p1.moveRightBy(5);

        assert p2.getX()==10;
    }

    @Test
    public void testComparingTowPoints(){
        Point p1 = new Point(10,15);
        Point p2 = new Point(10,16);

        int result = Point.compareByXAndThenY.compare(p1,p2);

        assert -1==result;
    }
}
